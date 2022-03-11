package domain.cliente.comand;

import co.com.sofka.domain.generic.Command;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.Fecha;

public class CrearCliente extends Command {
    private final ClienteId clienteId;
    private final Fecha fecha;

    public CrearCliente(ClienteId clienteId) {
        this.clienteId = clienteId;
        this.fecha = new Fecha();
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
