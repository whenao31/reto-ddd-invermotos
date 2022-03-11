package domain.venta.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.comand.CrearVenta;
import domain.venta.valueobject.VentaId;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVenta> input) {
        CrearVenta crearVenta = input.getCommand();

//        Crear entidad del evento sacando los parametros del evento obtenido desde el wrapper
        Venta venta = new Venta(crearVenta.getVentaId(),crearVenta.getMotoId(),crearVenta.getClienteId());

//        Emitir respuesta con un paquete de eventos con los cambios no confirmados
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
