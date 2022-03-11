package domain.moto.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.CrearAdicional;

public class CrearAdicionalUseCase extends UseCase<RequestCommand<CrearAdicional>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAdicional> input) {
        var command = input.getCommand();

        var moto = Moto.from(command.getMotoId(), retrieveEvents());
        if (moto.adicionales().values().size() >= 3){
            throw new BusinessException(command.getMotoId().value(),"Comuniquese con el representante para consultar si se pueden mas de 3 adicionales.");
        }
        moto.crearAdicional(command.getAdicionalId(), command.getEstado(), command.getDescripcion());
        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
