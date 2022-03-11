package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.moto.command.CrearMoto;
import domain.moto.event.MotoCreada;
import domain.moto.valueobject.DisponibilidadMoto;
import domain.moto.valueobject.MotoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearMotoUseCaseTest {

    @Test
    void crearMoto() {
//        Arrange
        MotoId motoId = MotoId.of("motoId1");
        DisponibilidadMoto disponibilidad = new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE);
        CrearMoto crearMoto = new CrearMoto(motoId, disponibilidad);

//        Act
        CrearMotoUseCase useCase = new CrearMotoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearMoto))
                .orElseThrow()
                .getDomainEvents();

//        Asset
        var event = (MotoCreada) events.get(0);
        Assertions.assertEquals("moto.motocreada", event.type);
        Assertions.assertEquals("motoId1", event.aggregateRootId());
        Assertions.assertEquals(DisponibilidadMoto.Estado.DISPONIBLE, event.getDisponibilidad().value());
    }
}