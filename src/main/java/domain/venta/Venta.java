package domain.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.venta.entities.*;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.*;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {
    protected MotoId motoId;
    protected ClienteId clienteId;
    protected List<TestDrive> testDrives;
    protected Cotizacion cotizacion;
    protected Factura factura;

    public Venta(VentaId ventaId, MotoId motoId, ClienteId clienteId) {
        super(ventaId);
        appendChange(new VentaCreada(motoId, clienteId)).apply();
        subscribe(new VentaEventChange(this));
    }

    public void cambiarVendedor(){

    }

    public void modificarFecha(){

    }

    public void modificarCosto(){

    }

    public void completarTestDrive(){

    }

    public void cancelarTestDrive(){

    }

}
