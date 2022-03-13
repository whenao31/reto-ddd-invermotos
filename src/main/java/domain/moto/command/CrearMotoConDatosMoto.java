package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.*;

public class CrearMotoConDatosMoto extends Command {
    private final MotoId motoId;
    private final DisponibilidadMoto disponibilidad;
    private final DatosMotoId datosMotoId;
    private final Modelo modelo;
    private final Color color;
    private final Linea linea;

    public CrearMotoConDatosMoto(MotoId motoId,
                                 DisponibilidadMoto disponibilidad,
                                 DatosMotoId datosMotoId,
                                 Modelo modelo,
                                 Color color,
                                 Linea linea) {
        this.motoId = motoId;
        this.disponibilidad = disponibilidad;
        this.datosMotoId = datosMotoId;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public DisponibilidadMoto getDisponibilidad() {
        return disponibilidad;
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
