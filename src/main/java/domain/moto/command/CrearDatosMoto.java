package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.*;

public class CrearDatosMoto extends Command {
    private final MotoId motoId;
    private final DatosMotoId datosMotoId;
    private final Modelo modelo;
    private final Color color;
    private final Linea linea;

    public CrearDatosMoto(MotoId motoId, DatosMotoId datosMotoId, Modelo modelo, Color color, Linea linea) {
        this.motoId  = motoId;
        this.datosMotoId = datosMotoId;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
    }

    public MotoId getMotoId() {
        return motoId;
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
