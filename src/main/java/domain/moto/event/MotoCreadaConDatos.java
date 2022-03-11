package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.DatosMoto;
import domain.moto.valueobject.DisponibilidadMoto;

public class MotoCreadaConDatos extends DomainEvent {
    private final DatosMoto datosMoto;
    private final DisponibilidadMoto disponibilidadMoto;

    public MotoCreadaConDatos(DatosMoto datosMoto, DisponibilidadMoto disponibilidad) {
        super("moto.motocreadacondatos");
        this.datosMoto = datosMoto;
        this.disponibilidadMoto = disponibilidad;
    }

    public DatosMoto getDatosMoto() {
        return datosMoto;
    }

    public DisponibilidadMoto getDisponibilidadMoto() {
        return disponibilidadMoto;
    }
}
