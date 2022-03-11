package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.Adicional;
import domain.moto.DatosMoto;
import domain.moto.Fabrica;
import domain.moto.valueobject.DisponibilidadMoto;
import domain.moto.valueobject.MotoId;

import java.util.Map;

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
