package domain.moto.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.event.AdicionalCreado;
import domain.moto.event.AdicionalInstalado;
import domain.moto.event.FabricaCreada;
import domain.moto.event.MotoCreada;
import domain.moto.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotificarAdicionalInstaladoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private SMSService service;

    @Test
    void enviarSMSARepresentanteFabrica(){
        var event = new AdicionalInstalado(AdicionalId.of("adicionalId1"));

        event.setAggregateRootId("motoId1");

        var useCase = new NotificarAdicionalInstaladoUseCase();
        Mockito.when(repository.getEventsBy("moto", "motoId1")).thenReturn(history());
        Mockito.when(service.enviarMensajeAFabrica(Mockito.any(FabricaId.class), Mockito.anyString())).thenReturn(true);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("motoId1")
                .syncExecutor(useCase, new TriggeredEvent<>(event)).isPresent();
        Assertions.assertTrue(isPresent);
    }


    private List<DomainEvent> history(){
        return List.of(
                new MotoCreada(new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE)),
                new FabricaCreada(FabricaId.of("fabricaId1"), new NombreFabrica("Girardota1"), new Representante()),
                new AdicionalCreado(AdicionalId.of("adicionalId1"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc1")),
                new AdicionalCreado(AdicionalId.of("adicionalId2"), new EstadoAdicional(EstadoAdicional.Fase.INSTALADO), new Descripcion("desc2")),
                new AdicionalCreado(AdicionalId.of("adicionalId3"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc3"))
        );
    }

}