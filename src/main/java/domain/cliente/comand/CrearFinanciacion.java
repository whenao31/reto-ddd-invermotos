package domain.cliente.comand;

import co.com.sofka.domain.generic.Command;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.Dinero;
import domain.cliente.valueobject.EstadoFinanciacion;
import domain.cliente.valueobject.FinanciacionId;

public class CrearFinanciacion extends Command {
    private final ClienteId clienteId;
    private final FinanciacionId financiacionId;
    private final EstadoFinanciacion estadoFinanciacion;
    private final Dinero tasaInteres;

    public CrearFinanciacion(ClienteId clienteId,
                             FinanciacionId financiacionId,
                             EstadoFinanciacion estadoFinanciacion,
                             Dinero tasaInteres) {
        this.clienteId = clienteId;
        this.financiacionId = financiacionId;
        this.estadoFinanciacion = estadoFinanciacion;
        this.tasaInteres = tasaInteres;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public FinanciacionId getFinanciacionId() {
        return financiacionId;
    }

    public EstadoFinanciacion getEstadoFinanciacion() {
        return estadoFinanciacion;
    }

    public Dinero getTasaInteres() {
        return tasaInteres;
    }
}
