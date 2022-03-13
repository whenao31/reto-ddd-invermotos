package domain.cliente.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cliente.comand.CrearCliente;
import domain.cliente.event.ClienteCreado;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.Fecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearClienteUseCaseTest {

    @Test
    void crearCliente() {
        //Arrange
        ClienteId clienteId = ClienteId.of("clienteId1");

        CrearCliente crearCliente = new CrearCliente(clienteId);

        //Act
        CrearClienteUseCase useCase = new CrearClienteUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearCliente))
                .orElseThrow()
                .getDomainEvents();

        //Asset
        var event = (ClienteCreado) events.get(0);
        Assertions.assertEquals("cliente.clientecreado", event.type);
        Assertions.assertEquals("clienteId1",event.aggregateRootId());
    }
}