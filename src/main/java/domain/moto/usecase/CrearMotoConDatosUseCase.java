package domain.moto.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.DatosMoto;
import domain.moto.Moto;
import domain.moto.command.CrearMotoConDatosMoto;

public class CrearMotoConDatosUseCase  extends UseCase<RequestCommand<CrearMotoConDatosMoto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMotoConDatosMoto> input) {
        CrearMotoConDatosMoto command = input.getCommand();

        Moto moto = new Moto(
                command.getMotoId(),
                command.getDisponibilidad(),
                command.getDatosMotoId(),
                command.getModelo(),
                command.getColor(),
                command.getLinea()
        );

        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
