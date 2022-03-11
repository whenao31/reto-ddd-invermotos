package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.AdicionalId;
import domain.moto.valueobject.Descripcion;
import domain.moto.valueobject.EstadoAdicional;

public class AdicionalCreado extends DomainEvent {
    private final AdicionalId adicionalId;
    private final EstadoAdicional estado;
    private final Descripcion descripcion;

    public AdicionalCreado(AdicionalId adicionalId, EstadoAdicional estado, Descripcion descripcion) {
        super("moto.adicionalcreado");
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
