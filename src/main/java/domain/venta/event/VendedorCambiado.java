package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.VendedorId;

public class VendedorCambiado extends DomainEvent {
    private final VendedorId vendedorId;

    public VendedorCambiado(VendedorId vendedorId) {
        super("venta.vendedorcambiado");
        this.vendedorId = vendedorId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
