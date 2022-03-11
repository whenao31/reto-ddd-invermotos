package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.FinanciacionId;

public class FinanciacionCreada extends DomainEvent {
    private final FinanciacionId financiacionId;
    private final double denomination;

    public FinanciacionCreada(FinanciacionId financiacionId, double denomination) {
        super("cliente.financiacioncreada");
        this.financiacionId = financiacionId;
        this.denomination = denomination;
    }

    public FinanciacionId getFinanciacionId() {
        return financiacionId;
    }

    public double getDenomination() {
        return denomination;
    }
}
