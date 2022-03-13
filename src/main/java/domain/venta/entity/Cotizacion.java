package domain.venta.entity;

import co.com.sofka.domain.generic.Entity;
import domain.venta.valueobject.CotizacionId;
import domain.venta.valueobject.Dinero;
import domain.venta.valueobject.Fecha;

public class Cotizacion extends Entity<CotizacionId> {
    private Fecha  fecha;
    private Dinero costoTotal;

    public Cotizacion(CotizacionId entityId) {
        super(entityId);
        this.fecha = new Fecha();
        this.costoTotal = null;
    }

    public void modificarCosto(double denomination){
        this.costoTotal = new Dinero(denomination);
    }

    public Fecha fecha() {
        return fecha;
    }

    public Dinero costoTotal() {
        return costoTotal;
    }
}