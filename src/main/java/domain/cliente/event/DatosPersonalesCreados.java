package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.DatosPersonalesId;
import domain.cliente.valueobject.Nombre;

public class DatosPersonalesCreados extends DomainEvent {
    private final DatosPersonalesId datosPersonalesId;
    private final Nombre nombre;

    public DatosPersonalesCreados(DatosPersonalesId datosPersonalesId, Nombre nombre) {
        super("cliente.datospersonalescreados");
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
    }

    public DatosPersonalesId getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
