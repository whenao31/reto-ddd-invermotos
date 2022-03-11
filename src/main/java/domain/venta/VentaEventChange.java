package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.event.*;
import domain.venta.valueobject.TestDriveId;

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
            venta.cambiarVendedor(event.getVendedorId());
        });

        apply((FechaModificada event) -> {
            venta.modificarFecha(event.getFechaString());
        });

        apply((CostoModificado event) -> {
            venta.modificarCosto(event.getDenomination());
        });

        apply((TestDriveCompletado event) -> {
            venta.testDrives.get(event.getTestDriveId().value()).completarTestDrive();
        });

        apply((TestDriveCancelado event) -> {
            venta.testDrives.get(event.getTestDriveId().value()).cancelarTestDrive();
        });

        apply((FacturaCreada event) ->{
            venta.crearFactura(event.getFacturaId(),event.getVendedorId());
        });

        apply((CotizacionCreada event) -> {
            venta.crearCotizacion(event.getCotizacionId(),event.getDenomination());
        });

        apply((TestDriveCreado event) -> {
            venta.crearTestDrive(event.getTestDriveId());
        });


    }
}
