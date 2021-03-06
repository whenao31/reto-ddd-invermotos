package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.entity.Cotizacion;
import domain.venta.entity.Factura;
import domain.venta.entity.TestDrive;
import domain.venta.event.*;

import java.util.HashMap;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {

        apply((VentaCreada event) -> {
            venta.motoId = event.getMotoId();
            venta.clienteId = event.getClienteId();
            venta.testDrives = new HashMap<>();
            venta.cotizacion = null;
            venta.factura = null;
        });

        apply((VendedorCambiado event) -> {
            venta.factura.cambiarVendedor(event.getVendedorId());
        });

        apply((FechaModificada event) -> {
            venta.factura.modificarFecha(event.getFechaString());
        });

        apply((CostoModificado event) -> {
            venta.cotizacion.modificarCosto(event.getDenomination());
        });

        apply((TestDriveCompletado event) -> {
            venta.testDrives.get(event.getTestDriveId().value()).completarTestDrive();
        });

        apply((TestDriveCancelado event) -> {
            venta.testDrives.get(event.getTestDriveId().value()).cancelarTestDrive();
        });

        apply((FacturaCreada event) ->{
            venta.factura = new Factura(event.getFacturaId(),event.getVendedorId());
        });

        apply((CotizacionCreada event) -> {
            venta.cotizacion = new Cotizacion(event.getCotizacionId());
        });

        apply((TestDriveCreado event) -> {
            venta.testDrives.put(event.getTestDriveId().value(),
                    new TestDrive(event.getTestDriveId()));
        });


    }
}
