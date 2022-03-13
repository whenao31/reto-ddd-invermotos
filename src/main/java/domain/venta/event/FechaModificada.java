package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.Fecha;

public class FechaModificada extends DomainEvent {
    private final String fechaString;
    public FechaModificada(String fechaString) {
        super("venta.fechamodificada");
        this.fechaString = fechaString;
    }

    public String getFechaString() {
        return fechaString;
    }
}
