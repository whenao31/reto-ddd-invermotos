package domain.moto;

import co.com.sofka.domain.generic.Entity;
import domain.moto.valueobject.AdicionalId;
import domain.moto.valueobject.Descripcion;
import domain.moto.valueobject.EstadoAdicional;

public class Adicional extends Entity<AdicionalId> {
    private EstadoAdicional estado;
    private Descripcion descripcion;

    public Adicional(AdicionalId entityId) {
        super(entityId);
        this.estado = new EstadoAdicional(EstadoAdicional.Fase.PENDIENTE);
        this.descripcion = new Descripcion();
    }

    public Adicional(AdicionalId entityId, EstadoAdicional estado, Descripcion descripcion) {
        super(entityId);
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public void instalarAdicional(){
        this.estado = new EstadoAdicional(EstadoAdicional.Fase.INSTALADO);
    }

    public EstadoAdicional estado() {
        return estado;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
