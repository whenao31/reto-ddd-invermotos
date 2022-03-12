package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.command.InstalarAdicional;
import domain.moto.event.AdicionalCreado;
import domain.moto.event.AdicionalInstalado;
import domain.moto.event.MotoCreada;
import domain.moto.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InstalarAdicionalUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void InstalarAdicional() {
//        Arrange
        MotoId motoId = MotoId.of("motoId1");
        AdicionalId adicionalId = AdicionalId.of("adicionalId3");

        var command = new InstalarAdicional(motoId, adicionalId);

        var useCase = new InstalarAdicionalUseCase();
        Mockito.when(repository.getEventsBy("motoId1")).thenReturn(history());
        useCase.addRepository(repository);

//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(motoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        Assert
        var event = (AdicionalInstalado) events.get(0);
        Assertions.assertEquals("moto.adicionalinstalado", event.type);
        Assertions.assertEquals("adicionalId3", event.getAdicionalId().value());
    }

    private List<DomainEvent> history(){
        return List.of(
                new MotoCreada(new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE)),
                new AdicionalCreado(AdicionalId.of("adicionalId1"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc1")),
                new AdicionalCreado(AdicionalId.of("adicionalId2"), new EstadoAdicional(EstadoAdicional.Fase.INSTALADO), new Descripcion("desc2")),
                new AdicionalCreado(AdicionalId.of("adicionalId3"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc3"))
        );
    }
}