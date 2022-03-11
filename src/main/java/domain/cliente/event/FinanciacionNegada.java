package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;

public class FinanciacionNegada extends DomainEvent {

    public FinanciacionNegada() {
        super("cliente.financiacionnegada");
    }
}
