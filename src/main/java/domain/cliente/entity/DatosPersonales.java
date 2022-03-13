package domain.cliente.entity;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.valueobject.DatosPersonalesId;
import domain.cliente.valueobject.Nombre;
import domain.cliente.valueobject.PuntajeCrediticio;

public class DatosPersonales extends Entity<DatosPersonalesId> {
    private PuntajeCrediticio puntajeCrediticio;
    private Nombre nombre;

    public DatosPersonales(DatosPersonalesId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
        this.puntajeCrediticio = new PuntajeCrediticio();
    }

    public void cambiarPuntaje(PuntajeCrediticio puntajeCrediticio){
        this.puntajeCrediticio = puntajeCrediticio;
    }

    public PuntajeCrediticio puntajeCrediticio() {
        return puntajeCrediticio;
    }

    public Nombre nombre() {
        return nombre;
    }
}
