package domain.cliente.entitie;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.valueobject.Dinero;
import domain.cliente.valueobject.EstadoFinanciacion;
import domain.cliente.valueobject.FinanciacionId;

public class Financiacion extends Entity<FinanciacionId> {
    private EstadoFinanciacion estado;
    private Dinero tasaInteres;

    public Financiacion(FinanciacionId entityId, Dinero tasaInteres) {
        super(entityId);
        this.tasaInteres = new Dinero(0.02);
        this.estado = new EstadoFinanciacion(EstadoFinanciacion.Estado.PENDIENTE);
    }

    public void aprobarFinanciacion(){
        this.estado = new EstadoFinanciacion(EstadoFinanciacion.Estado.APROBADO);
    }

    public void negarFinanciacion(){
        this.estado = new EstadoFinanciacion(EstadoFinanciacion.Estado.NO_APROBADO);
    }

    public EstadoFinanciacion estado() {
        return estado;
    }

    public Dinero tasaInteres() {
        return tasaInteres;
    }
}
