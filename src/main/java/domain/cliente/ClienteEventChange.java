package domain.cliente;

import co.com.sofka.domain.generic.EventChange;
import domain.cliente.entity.DatosPersonales;
import domain.cliente.entity.Financiacion;
import domain.cliente.event.*;
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
            cliente.financiacion.aprobarFinanciacion();
        });

        apply((FinanciacionNegada event) -> {
            cliente.financiacion.negarFinanciacion();
        });

        apply((DatosPersonalesCreados event) -> {
            cliente.datosPersonales = new DatosPersonales(event.getDatosPersonalesId(), event.getNombre());
        });

        apply((FinanciacionCreada event) -> {
            cliente.financiacion = new Financiacion(event.getFinanciacionId(), event.getTasaInteres());
        });



    }
}
