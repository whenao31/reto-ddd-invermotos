package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.DatosPersonalesId;
import domain.cliente.valueobject.Nombre;
import domain.cliente.valueobject.PuntajeCrediticio;

import java.awt.*;

public class ClienteCreadoConDatos extends DomainEvent {
    private final DatosPersonalesId datosPersonalesId;
    private final Nombre nombre;
    private final PuntajeCrediticio puntajeCrediticio;

    public ClienteCreadoConDatos(DatosPersonalesId datosPersonalesId,
                                 Nombre nombre,
                                 PuntajeCrediticio puntajeCrediticio) {
        super("cliente.clientecreadocondatos");
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.puntajeCrediticio = puntajeCrediticio;
    }

    public DatosPersonalesId getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PuntajeCrediticio getPuntajeCrediticio() {
        return puntajeCrediticio;
    }
}
