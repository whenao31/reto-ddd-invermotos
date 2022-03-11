package domain.cliente.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cliente.comand.CrearClienteConDatos;
import domain.cliente.event.ClienteCreadoConDatos;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.DatosPersonalesId;
import domain.cliente.valueobject.Nombre;
import domain.cliente.valueobject.PuntajeCrediticio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearClienteConDatosUseCaseTest {

    @Test
    void crearClienteConDatos() {
        //Arrange
        ClienteId clienteId = ClienteId.of("clienteId1");
        DatosPersonalesId datosPersonalesId = DatosPersonalesId.of("datosPId1");
        Nombre nombre = new Nombre("Camilo");
        PuntajeCrediticio puntajeCrediticio = new PuntajeCrediticio();

        CrearClienteConDatos crearClienteConDatos = new CrearClienteConDatos(
                clienteId,
                datosPersonalesId,
                nombre
        );

        //Act
        CrearClienteConDatosUseCase useCase = new CrearClienteConDatosUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(crearClienteConDatos))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (ClienteCreadoConDatos) events.get(0);
        Assertions.assertEquals("cliente.clientecreadocondatos", event.type);
        Assertions.assertEquals("clienteId1",event.aggregateRootId());
        Assertions.assertEquals("datosPId1", event.getDatosPersonalesId().value());
        Assertions.assertEquals("Camilo", event.getNombre().value());
        Assertions.assertEquals(PuntajeCrediticio.Puntaje.ESTUDIO,event.getPuntajeCrediticio().value());

    }
}