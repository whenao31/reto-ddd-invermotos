package domain.moto.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.CrearMoto;
import domain.moto.valueobject.MotoId;

public class CrearMotoUseCase extends UseCase<RequestCommand<CrearMoto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMoto> input) {
        CrearMoto crearMoto = input.getCommand();

//        Crear entidad del evento sacando los parametros del evento obtenido desde el wrapper
        Moto moto = new Moto(crearMoto.getMotoId(), crearMoto.getDisponibilidad());

//        Emitir respuesta con un paquete de eventos con los cambios no confirmados
        emit().onResponse(new ResponseEvents(moto.getUncommittedChanges()));
    }
}
