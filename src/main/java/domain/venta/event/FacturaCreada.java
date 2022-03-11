package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.FacturaId;
import domain.venta.valueobject.VendedorId;

public class FacturaCreada extends DomainEvent {
    private final FacturaId facturaId;
    private final VendedorId vendedorId;
    public FacturaCreada(FacturaId facturaId, VendedorId vendedorId) {
        super("venta.facturacreada");
        this.facturaId = facturaId;
        this.vendedorId = vendedorId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
