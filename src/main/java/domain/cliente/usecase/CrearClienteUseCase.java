package domain.cliente.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.comand.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCliente> input) {
        CrearCliente crearCliente = input.getCommand();

        Cliente cliente = new Cliente(crearCliente.getClienteId(), crearCliente.getFecha());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
