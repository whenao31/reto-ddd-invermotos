package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.Descripcion;
import domain.moto.valueobject.EstadoAdicional;
import domain.moto.valueobject.MotoId;

public class CrearAdicional extends Command {
    private final MotoId motoId;
    private final EstadoAdicional estado;
    private final Descripcion descripcion;

    public CrearAdicional(MotoId motoId, EstadoAdicional estado, Descripcion descripcion) {
        this.motoId = motoId;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public EstadoAdicional getEstado() {
        return estado;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
