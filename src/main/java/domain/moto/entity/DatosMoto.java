package domain.moto.entity;

import co.com.sofka.domain.generic.Entity;
import domain.moto.valueobject.Color;
import domain.moto.valueobject.DatosMotoId;
import domain.moto.valueobject.Linea;
import domain.moto.valueobject.Modelo;

import java.time.LocalDate;

public class DatosMoto extends Entity<DatosMotoId> {
    private Modelo modelo;
    private Color color;
    private Linea linea;

    public DatosMoto(DatosMotoId motoId) {
        super(motoId);
        this.modelo = new Modelo(LocalDate.now().getYear());
        this.color = new Color(Color.Opcion.NEUTRO);
        this.linea = new Linea();
    }

    public DatosMoto(DatosMotoId entityId, Modelo modelo, Color color, Linea linea) {
        super(entityId);
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
    }

    public void pintar(Color.Opcion color){
        this.color = new Color(color);
    }

    public void cambiarModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void cambiarLinea(Linea linea){
        this.linea = linea;
    }

    public Modelo modelo() {
        return modelo;
    }

    public Color color() {
        return color;
    }

    public Linea linea() {
        return linea;
    }
}
