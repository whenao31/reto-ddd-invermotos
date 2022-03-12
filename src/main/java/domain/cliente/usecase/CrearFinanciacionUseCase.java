package domain.cliente.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.comand.CrearFinanciacion;

import java.util.Objects;

public class CrearFinanciacionUseCase extends UseCase<RequestCommand<CrearFinanciacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFinanciacion> input) {
        var command = input.getCommand();

        var cliente = Cliente.from(command.getClienteId(),retrieveEvents());
        if (Objects.nonNull(cliente.financiacion())){
            throw new BusinessException(command.getClienteId().value(),"Financiacion ya asignada");
        }
        cliente.crearFinanciacion(command.getFinanciacionId(),command.getEstadoFinanciacion(),command.getTasaInteres());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
