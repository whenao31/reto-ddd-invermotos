package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.CotizacionId;

public class CotizacionCreada extends DomainEvent {
    private final CotizacionId cotizacionId;
    private final double denomination;

    public CotizacionCreada(CotizacionId cotizacionId, double denomination) {
        super("venta.cotizacioncreada");
        this.cotizacionId = cotizacionId;
        this.denomination = denomination;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public double getDenomination() {
        return denomination;
    }
}
