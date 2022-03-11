package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.FinanciacionId;

public class FinanciacionAprobada extends DomainEvent {
    private final FinanciacionId financiacionId;

    public FinanciacionAprobada(FinanciacionId financiacionId) {
        super("financiacionaprobada");
        this.financiacionId = financiacionId;
    }

    public FinanciacionId getFinanciacionId() {
        return financiacionId;
    }
}
