package domain.moto.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.moto.command.CrearMotoConDatosMoto;
import domain.moto.event.MotoCreadaConDatos;
import domain.moto.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearMotoConDatosUseCaseTest {

    @Test
    void crearMotoConDatos() {
//        Arrange
        MotoId motoId = MotoId.of("motoId1");
        DisponibilidadMoto disponibilidad = new DisponibilidadMoto(DisponibilidadMoto.Estado.DISPONIBLE);

        DatosMotoId datosMotoId = DatosMotoId.of("datosmotoId1");
        Modelo modelo = new Modelo(2022);
        Color color = new Color(Color.Opcion.NEGRO);
        Linea linea = new Linea("scooter");

        CrearMotoConDatosMoto crearMotoConDatosMoto = new CrearMotoConDatosMoto(
                motoId,
                disponibilidad,
                datosMotoId,
                modelo,
                color,
                linea
        );

//        Act
        CrearMotoConDatosUseCase useCase = new CrearMotoConDatosUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearMotoConDatosMoto))
                .orElseThrow()
                .getDomainEvents();

        var event = (MotoCreadaConDatos) events.get(0);
        Assertions.assertEquals("moto.motocreadacondatos", event.type);
        Assertions.assertEquals("motoId1", event.aggregateRootId());
        Assertions.assertEquals("datosmotoId1", event.getDatosMotoId().value());
        Assertions.assertEquals(Color.Opcion.NEGRO, event.getColor().value());
    }
}