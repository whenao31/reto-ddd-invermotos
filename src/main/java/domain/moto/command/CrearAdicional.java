package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.AdicionalId;
import domain.moto.valueobject.Descripcion;
import domain.moto.valueobject.EstadoAdicional;

public class CrearAdicional extends Command {
    private final AdicionalId adicionalId;
    private final EstadoAdicional estado;
    private final Descripcion descripcion;

    public CrearAdicional(AdicionalId adicionalId, EstadoAdicional estado, Descripcion descripcion) {
        this.adicionalId = adicionalId;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public AdicionalId getAdicionalId() {
        return adicionalId;
    }

    public EstadoAdicional getEstado() {
        return estado;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
