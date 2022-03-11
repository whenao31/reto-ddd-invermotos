package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.moto.DatosMoto;
import domain.moto.command.CrearMotoConDatosMoto;
import domain.moto.event.MotoCreadaConDatos;
import domain.moto.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearMotoConDatosUseCaseTest {

    @Test
    void crearMotoConDatos() {
//        Arrange
        MotoId motoId = MotoId.of("motoId1");

        DatosMotoId datosMotoId = DatosMotoId.of("datosmotoId1");
        Modelo modelo = new Modelo(2022);
        Color color = new Color(Color.Opcion.NEGRO);
        Linea linea = new Linea("scooter");
        DatosMoto datosMoto = new DatosMoto(datosMotoId, modelo, color, linea);

        DisponibilidadMoto disponibilidad = new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE);

        CrearMotoConDatosMoto crearMotoConDatosMoto = new CrearMotoConDatosMoto(motoId, datosMoto, disponibilidad);

//        Act
        CrearMotoConDatosUseCase useCase = new CrearMotoConDatosUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearMotoConDatosMoto))
                .orElseThrow()
                .getDomainEvents();

        var event = (MotoCreadaConDatos) events.get(0);
        Assertions.assertEquals("moto.motocreadacondatos", event.type);
        Assertions.assertEquals("motoId1", event.aggregateRootId());
        Assertions.assertEquals("datosmotoId1", event.getDatosMoto().identity().value());
        Assertions.assertEquals(Color.Opcion.NEGRO, event.getDatosMoto().color().value());
    }
}