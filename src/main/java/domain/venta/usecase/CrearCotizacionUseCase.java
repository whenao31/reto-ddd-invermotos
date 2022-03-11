package domain.venta.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.comand.CrearCotizacion;

import java.util.Objects;

public class CrearCotizacionUseCase extends UseCase<RequestCommand<CrearCotizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCotizacion> input) {

        var command = input.getCommand();

        var venta = Venta.from(command.getVentaId(),retrieveEvents());
        if (Objects.nonNull(venta.cotizacion())){
            throw new BusinessException(command.getVentaId().value(), "Cotizacion ya creada");
        }
        venta.crearCotizacion(command.getCotizacionId());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
