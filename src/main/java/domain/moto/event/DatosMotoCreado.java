package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.DatosMoto;
import domain.moto.valueobject.Color;
import domain.moto.valueobject.DatosMotoId;
import domain.moto.valueobject.Linea;
import domain.moto.valueobject.Modelo;

public class DatosMotoCreado extends DomainEvent {
    private final DatosMotoId datosMotoId;
    private final Modelo modelo;
    private final Color color;
    private final Linea linea;

    public DatosMotoCreado(DatosMotoId datosMotoId, Modelo modelo, Color color, Linea linea) {
        super("moto.datosmotocreado");
        this.datosMotoId = datosMotoId;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
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
