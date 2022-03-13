package domain.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.entitie.*;
import domain.venta.event.*;
import domain.venta.valueobject.*;

import java.util.List;
import java.util.Map;

public class Venta extends AggregateEvent<VentaId> {
    protected MotoId                 motoId;
    protected ClienteId              clienteId;
    protected Map<String, TestDrive> testDrives;
    protected Cotizacion             cotizacion;
    protected Factura                factura;

    public Venta(VentaId ventaId, MotoId motoId, ClienteId clienteId) {
        super(ventaId);
        appendChange(new VentaCreada(motoId, clienteId)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId ventaId) {
        super(ventaId);
        subscribe(new VentaEventChange(this));
    }

    //Reestablecer el estado del agregado
    public static Venta from(VentaId ventaId, List<DomainEvent> events) {
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void cambiarVendedor(VendedorId vendedorId) {
        appendChange(new VendedorCambiado(vendedorId)).apply();
    }

    public void modificarFecha(String fechaString) {
        appendChange(new FechaModificada(fechaString)).apply();
    }

    public void modificarCosto(double denomination) {
        appendChange(new CostoModificado(denomination)).apply();
    }

    public void completarTestDrive(TestDriveId testDriveId) {
        appendChange(new TestDriveCompletado(testDriveId)).apply();
    }

    public void cancelarTestDrive(TestDriveId testDriveId) {
        appendChange(new TestDriveCancelado(testDriveId)).apply();
    }

    public void crearFactura(FacturaId facturaId, VendedorId vendedorId) {
        appendChange(new FacturaCreada(facturaId, vendedorId)).apply();
    }

    public void crearCotizacion(CotizacionId cotizacionId) {
        appendChange(new CotizacionCreada(cotizacionId)).apply();
    }

    public void crearTestDrive(TestDriveId testDriveId) {
        appendChange(new TestDriveCreado(testDriveId)).apply();
    }

    public Map<String, TestDrive> testDrives() {
        return testDrives;
    }

    public Cotizacion cotizacion() {
        return cotizacion;
    }

    public Factura factura() {
        return factura;
    }
}
