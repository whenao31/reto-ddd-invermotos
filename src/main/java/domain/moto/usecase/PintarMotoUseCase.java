package domain.moto.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.PintarMoto;
import domain.moto.valueobject.Color;

public class PintarMotoUseCase extends UseCase<RequestCommand<PintarMoto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<PintarMoto> input) {
        var command = input.getCommand();

        var moto = Moto.from(command.getMotoId(), retrieveEvents());
        if (!moto.datosMoto().color().value().equals(Color.Opcion.NEUTRO)){
            throw new BusinessException(command.getMotoId().value(), "La moto ya ha sido pintada.");
        }

        moto.pintar(command.getColor().value());
        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
