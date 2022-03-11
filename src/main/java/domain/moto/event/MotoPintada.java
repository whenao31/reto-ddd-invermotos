package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.Color;
import domain.moto.valueobject.DatosMotoId;

public class MotoPintada extends DomainEvent {
    private final Color.Opcion color;

    public MotoPintada(Color.Opcion color) {
        super("moto.motopintada");
        this.color = color;
    }

    public Color.Opcion getColor() {
        return color;
    }
}
