package domain.cliente.comand;

import co.com.sofka.domain.generic.Command;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.DatosPersonalesId;
import domain.cliente.valueobject.Nombre;
import domain.cliente.valueobject.PuntajeCrediticio;

public class CrearClienteConDatos extends Command {
    private final ClienteId clienteId;
    private final DatosPersonalesId datosPersonalesId;
    private final Nombre nombre;
    private final PuntajeCrediticio puntajeCrediticio;

    public CrearClienteConDatos(ClienteId clienteId,
                                DatosPersonalesId datosPersonalesId,
                                Nombre nombre
                                ) {
        this.clienteId = clienteId;
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.puntajeCrediticio = new PuntajeCrediticio();
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonalesId getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PuntajeCrediticio getPuntajeCrediticio() {
        return puntajeCrediticio;
    }
}
