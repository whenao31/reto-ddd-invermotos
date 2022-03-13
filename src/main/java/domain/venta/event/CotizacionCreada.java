package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.CotizacionId;

public class CotizacionCreada extends DomainEvent {
    private final CotizacionId cotizacionId;

    public CotizacionCreada(CotizacionId cotizacionId) {
        super("venta.cotizacioncreada");
        this.cotizacionId = cotizacionId;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

}
