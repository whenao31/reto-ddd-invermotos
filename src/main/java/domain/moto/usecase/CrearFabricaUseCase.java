package domain.moto.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.CrearFabrica;

import java.util.Objects;

public class CrearFabricaUseCase extends UseCase<RequestCommand<CrearFabrica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFabrica> input) {
        var command = input.getCommand();

//        obtengo la Moto a partir de la historia de eventos del agregado
        var moto = Moto.from(command.getMotoId(), retrieveEvents());
        if (Objects.nonNull(moto.fabrica())){//Regla de negocio
            throw new BusinessException(command.getMotoId().value(), "Fabrica ya asignada");
        }
        moto.crearFabrica(command.getFabricaId(), command.getNombre(), command.getRepresentante());

        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
