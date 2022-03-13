package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;

public class CostoModificado extends DomainEvent {
    private final double denomination;

    public CostoModificado(double denomination) {
        super("venta.costomodificado");
        this.denomination = denomination;
    }

    public double getDenomination() {
        return denomination;
    }
}
