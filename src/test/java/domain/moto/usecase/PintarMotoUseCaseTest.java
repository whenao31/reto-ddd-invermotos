package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.command.PintarMoto;
import domain.moto.event.MotoCreadaConDatos;
import domain.moto.event.MotoPintada;
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
class PintarMotoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void PintarMoto(){
//        Arrange
        MotoId motoId = MotoId.of("motoId1");
        Color color = new Color(Color.Opcion.NEGRO);

        var command = new PintarMoto(motoId, color);

        var useCase = new PintarMotoUseCase();
        Mockito.when(repository.getEventsBy("motoId1")).thenReturn(history());
        useCase.addRepository(repository);

//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(motoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        Assert
        var event = (MotoPintada) events.get(0);
        Assertions.assertEquals("moto.motopintada", event.type);
        Assertions.assertEquals(Color.Opcion.NEGRO, event.getColor());
    }

    private List<DomainEvent> history(){
        return List.of(
                new MotoCreadaConDatos(
                        new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE),
                        DatosMotoId.of("datosMotoId1"),
                        new Modelo(2022),
                        new Color(Color.Opcion.NEUTRO),
                        new Linea("scooter")
                )
        );
    }

}