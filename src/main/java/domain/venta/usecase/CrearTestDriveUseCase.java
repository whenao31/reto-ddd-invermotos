package domain.venta.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.comand.CrearTestDrive;

public class CrearTestDriveUseCase extends UseCase<RequestCommand<CrearTestDrive>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTestDrive> input) {
        var command = input.getCommand();

        var venta = Venta.from(command.getVentaId(), retrieveEvents());
        if (venta.testDrives().values().size() > 2) {
            throw new BusinessException(command.getVentaId().value(),
                    "Solicite con el concecionario si puede tener mas de 2 TestDrive");
        }
        venta.crearTestDrive(command.getTestDriveId());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
