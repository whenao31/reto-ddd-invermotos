package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;

public class FinanciacionAprobada extends DomainEvent {

    public FinanciacionAprobada() {
        super("cliente.financiacionaprobada");
    }
}
