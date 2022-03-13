package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.entitie.DatosPersonales;
import domain.cliente.entitie.Financiacion;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.Fecha;

public class ClienteCreado extends DomainEvent {
    private final ClienteId clienteId;
    private final Fecha fecha;

    public ClienteCreado(ClienteId clienteId, Fecha fecha) {
        super("cliente.clientecreado");
        this.clienteId = clienteId;
        this.fecha = fecha;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
