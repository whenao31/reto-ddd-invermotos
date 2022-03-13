package domain.venta.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.comand.CrearFactura;

import java.util.Objects;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFactura> input) {

        var command = input.getCommand();

        var venta = Venta.from(command.getVentaId(), retrieveEvents());
        if (Objects.nonNull(venta.factura())){
            throw new BusinessException(command.getVentaId().value(), "Factura ya creada");
        }
        venta.crearFactura(command.getFacturaId(), command.getVendedorId());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
