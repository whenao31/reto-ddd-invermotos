package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.command.CrearAdicional;
import domain.moto.event.AdicionalCreado;
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
class CrearAdicionalUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearAdicional(){
//        Arrange
        MotoId motoId = MotoId.of("motoId1");
        AdicionalId adicionalId = AdicionalId.of("adicionalId4");
        EstadoAdicional estadoAdicional= new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE);
        Descripcion descripcion = new Descripcion("desc4");

        var command = new CrearAdicional(motoId, adicionalId, estadoAdicional, descripcion);

        var usecase = new CrearAdicionalUseCase();
        Mockito.when(repository.getEventsBy("motoId1")).thenReturn(history());
        usecase.addRepository(repository);

//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(motoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        Assert
        var event = (AdicionalCreado) events.get(0);
        Assertions.assertEquals("moto.adicionalcreado", event.type);
        Assertions.assertEquals("adicionalId4", event.getAdicionalId().value());
        Assertions.assertEquals(EstadoAdicional.Fase.PENDIENTE, event.getEstado().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new MotoCreada(new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE)),
                new AdicionalCreado(AdicionalId.of("adicional1"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc1")),
//                new AdicionalCreado(AdicionalId.of("adicional2"), new EstadoAdicional(EstadoAdicional.Fase.INSTALADO), new Descripcion("desc2")),
                new AdicionalCreado(AdicionalId.of("adicional3"), new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE), new Descripcion("desc3"))
        );
    }
}