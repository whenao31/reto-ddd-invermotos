package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.MotoId;

public class VentaCreada extends DomainEvent {
    private final MotoId motoId;
    private final ClienteId clienteId;

    public VentaCreada(MotoId motoId, ClienteId clienteId) {
        super("venta.ventacreada");
        this.motoId = motoId;
        this.clienteId = clienteId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
