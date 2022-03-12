package domain.moto.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.InstalarAdicional;
import domain.moto.valueobject.EstadoAdicional;

public class InstalarAdicionalUseCase extends UseCase<RequestCommand<InstalarAdicional>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<InstalarAdicional> input) {
        var command = input.getCommand();

        var moto = Moto.from(command.getMotoId(), retrieveEvents());
        if (moto.adicionales()
                .get(command.getAdicionalId().value())
                .estado().value()
                .equals(EstadoAdicional.Fase.INSTALADO)){
            throw new BusinessException(command.getMotoId().value(), "Adicional ya ha sido instalado");
        }

        moto.instalarAdicional(command.getAdicionalId());
        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
