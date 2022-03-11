package domain.moto.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.moto.Moto;
import domain.moto.command.CrearFabrica;

public class CrearFabricaUseCase extends UseCase<RequestCommand<CrearFabrica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFabrica> input) {
        var command = input.getCommand();

        var moto = Moto.from(command.getMotoId(), retrieveEvents());
    }
}
