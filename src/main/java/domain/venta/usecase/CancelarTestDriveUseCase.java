package domain.venta.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.comand.CancelarTestDrive;
import domain.venta.valueobject.EstadoTestDrive;

public class CancelarTestDriveUseCase extends UseCase<RequestCommand<CancelarTestDrive>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CancelarTestDrive> input) {
        var command = input.getCommand();

        var venta = Venta.from(command.getVentaId(), retrieveEvents());
        if (venta.testDrives()
                .get(command.getTestDriveId().value())
                .estadoTestDrive()
                .value()
                .equals(EstadoTestDrive.Estado.PENDIENTE)){
            venta.cancelarTestDrive((command.getTestDriveId()));
            emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
        }else {
            throw new BusinessException(command.getVentaId().value(), "El TestDrive No se puede cancelar");
        }
    }
}
