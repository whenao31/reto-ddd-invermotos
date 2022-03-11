package domain.cliente;

import co.com.sofka.domain.generic.EventChange;
import domain.cliente.event.ClienteCreado;
import domain.cliente.event.FinanciacionAprobada;
import domain.cliente.event.PuntajeCambiado;
import domain.cliente.valueobject.Fecha;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {

        apply((ClienteCreado event) ->{
            cliente.datosPersonales = null;
            cliente.financiacion = null;
            cliente.fecha = new Fecha();
        });

        apply((PuntajeCambiado event) ->{
            cliente.datosPersonales.cambiarPuntaje(event.getPuntajeCrediticio());
        });

        apply((FinanciacionAprobada event) -> {
            cliente.financiacion.aprobarFinanciacion(); //Revisar
        });




    }
}
