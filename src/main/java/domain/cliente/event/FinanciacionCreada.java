package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.valueobject.Dinero;
import domain.cliente.valueobject.EstadoFinanciacion;
import domain.cliente.valueobject.FinanciacionId;

public class FinanciacionCreada extends DomainEvent {
    private final FinanciacionId financiacionId;
    private final Dinero tasaInteres;
    private final EstadoFinanciacion estadoFinanciacion;

    public FinanciacionCreada(FinanciacionId financiacionId,
                              EstadoFinanciacion estadoFinanciacion,
                              Dinero tasaInteres) {
        super("cliente.financiacioncreada");
        this.financiacionId = financiacionId;
        this.tasaInteres = tasaInteres;
        this.estadoFinanciacion = estadoFinanciacion;
    }

    public FinanciacionId getFinanciacionId() {
        return financiacionId;
    }

    public Dinero getTasaInteres() {
        return tasaInteres;
    }

    public EstadoFinanciacion getEstadoFinanciacion() {
        return estadoFinanciacion;
    }
}
