package domain.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.entitie.DatosPersonales;
import domain.cliente.entitie.Financiacion;
import domain.cliente.event.ClienteCreado;
import domain.cliente.event.FinanciacionAprobada;
import domain.cliente.event.PuntajeCambiado;
import domain.cliente.valueobject.ClienteId;
import domain.cliente.valueobject.Fecha;
import domain.cliente.valueobject.FinanciacionId;
import domain.cliente.valueobject.PuntajeCrediticio;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {
    protected DatosPersonales datosPersonales;
    protected Financiacion financiacion;
    protected Fecha fecha;

    public Cliente(ClienteId clienteId, Fecha fecha) {
        super(clienteId);
        appendChange(new ClienteCreado(clienteId, fecha)).apply();
        subscribe(new ClienteEventChange(this));
    }

    private Cliente(ClienteId clienteId){
        super(clienteId);
        subscribe(new ClienteEventChange(this));
    }

    private static Cliente from(ClienteId clienteId, List<DomainEvent> events) {
        var cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void cambiarPuntaje(PuntajeCrediticio puntajeCrediticio){
        appendChange(new PuntajeCambiado(puntajeCrediticio)).apply();
    }

    public void aprobarFinanciacion(FinanciacionId financiacionId){
        appendChange(new FinanciacionAprobada(financiacionId)).apply();
    }

    public void negarFinanciacion(){
       // appendChange(new FinanciacionNegada()).apply();
    }
}
