package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.Linea;

public class LineaCambiada extends DomainEvent {
    private final Linea linea;

    public LineaCambiada(Linea linea) {
        super("moto.lineacambiada");
        this.linea = linea;
    }

    public Linea getLinea() {
        return linea;
    }
}
