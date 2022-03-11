package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.AdicionalId;
import domain.moto.valueobject.Descripcion;
import domain.moto.valueobject.EstadoAdicional;
import domain.moto.valueobject.MotoId;

public class CrearAdicional extends Command {
    private final MotoId motoId;
    private final AdicionalId adicionalId;
    private final EstadoAdicional estado;
    private final Descripcion descripcion;

    public CrearAdicional(MotoId motoId, AdicionalId adicionalId, EstadoAdicional estado, Descripcion descripcion) {
        this.motoId = motoId;
        this.adicionalId = adicionalId;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public MotoId getMotoId() {
        return motoId;
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
