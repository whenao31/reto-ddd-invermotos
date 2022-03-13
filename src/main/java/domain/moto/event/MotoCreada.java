package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.DisponibilidadMoto;

public class MotoCreada extends DomainEvent {
    private final DisponibilidadMoto disponibilidad;

    public MotoCreada(DisponibilidadMoto disponibilidad) {
        super("moto.motocreada");
        this.disponibilidad = disponibilidad;
    }

    public DisponibilidadMoto getDisponibilidad() {
        return disponibilidad;
    }
}
