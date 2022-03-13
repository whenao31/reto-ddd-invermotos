package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.*;

public class MotoCreadaConDatos extends DomainEvent {
    private final DisponibilidadMoto disponibilidadMoto;
    private final DatosMotoId datosMotoId;
    private final Modelo modelo;
    private final Color color;
    private final Linea linea;

    public MotoCreadaConDatos(DisponibilidadMoto disponibilidad,
                              DatosMotoId datosMotoId,
                              Modelo modelo,
                              Color color,
                              Linea linea) {
        super("moto.motocreadacondatos");
        this.disponibilidadMoto = disponibilidad;
        this.datosMotoId = datosMotoId;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
    }

    public DisponibilidadMoto getDisponibilidadMoto() {
        return disponibilidadMoto;
    }

    public DatosMotoId getDatosMotoId() {
        return datosMotoId;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Color getColor() {
        return color;
    }

    public Linea getLinea() {
        return linea;
    }
}
