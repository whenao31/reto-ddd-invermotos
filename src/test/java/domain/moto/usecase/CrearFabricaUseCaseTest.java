package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.command.CrearFabrica;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearFabricaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void CrearFabrica(){
//        arrange
        MotoId motoId = MotoId.of("motoId1");

        FabricaId fabricaId = FabricaId.of("fabricaId1");
        var command = new CrearFabrica(
                motoId,
                fabricaId,
                new NombreFabrica("Girardota 1"),
                new Representante(Representante.Categoria.BRONCE, "Pedro Perez")
        );

        var usecase = new CrearFabricaUseCase();
        Mockito.when(repository.getEventsBy("motoId1")).thenReturn(history());
        usecase.addRepository(repository);

//        act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(motoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var event = (FabricaCreada) events.get(0);
        Assertions.assertEquals("moto.fabricacreada", event.type);
        Assertions.assertEquals("fabricaId1", event.getFabricaId().value());
        Assertions.assertEquals(Representante.Categoria.BRONCE, event.getRepresentante().value().categoria());
    }


    private List<DomainEvent> history() {
        return List.of(
                new MotoCreada(new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE))
        );
    }
}