package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.PuntajeCrediticio;

public class PuntajeCambiado extends DomainEvent {
    private final PuntajeCrediticio puntajeCrediticio;

    public PuntajeCambiado(PuntajeCrediticio puntajeCrediticio) {
        super("cliente.puntajecambiado");
        this.puntajeCrediticio = puntajeCrediticio;
    }

    public PuntajeCrediticio getPuntajeCrediticio() {
        return puntajeCrediticio;
    }
}
