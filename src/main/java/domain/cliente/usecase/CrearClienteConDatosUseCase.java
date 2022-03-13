package domain.cliente.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.comand.CrearClienteConDatos;

public class CrearClienteConDatosUseCase extends UseCase<RequestCommand<CrearClienteConDatos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteConDatos> input) {
        CrearClienteConDatos command = input.getCommand();

        Cliente cliente = new Cliente(
                command.getClienteId(),
                command.getDatosPersonalesId(),
                command.getNombre(),
                command.getPuntajeCrediticio()
        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
