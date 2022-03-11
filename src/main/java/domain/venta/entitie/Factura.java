package domain.venta.entitie;

import co.com.sofka.domain.generic.Entity;
import domain.venta.valueobject.FacturaId;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.VendedorId;

public class Factura extends Entity<FacturaId> {
    private Fecha fecha;
    private VendedorId vendedorId;

    public Factura(FacturaId entityId, VendedorId vendedorId) {
        super(entityId);
        this.vendedorId = new VendedorId();
        this.fecha = new Fecha();
    }

    public void cambiarVendedor(VendedorId vendedorId){
        this.vendedorId = vendedorId;
    }

    public void modificarFecha(String fechaString){
        this.fecha = new Fecha(fechaString);
    }

    public Fecha fecha() {
        return fecha;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }
}

