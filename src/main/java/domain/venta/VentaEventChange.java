package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.event.VentaCreada;

import java.util.ArrayList;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {

        apply((VentaCreada event) ->{
            venta.motoId = event.getMotoId();
            venta.clienteId = event.getClienteId();
            venta.testDrives = new ArrayList<>();
            venta.cotizacion = null;
            venta.factura = null;
        });


    }
}
