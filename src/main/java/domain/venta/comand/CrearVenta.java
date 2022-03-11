package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.MotoId;
import domain.venta.valueobject.VentaId;

public class CrearVenta extends Command {
    private final VentaId   ventaId;
    private final MotoId    motoId;
    private final ClienteId clienteId;


    public CrearVenta(VentaId ventaId, MotoId motoId, ClienteId clienteId) {
        this.ventaId = ventaId;
        this.motoId = motoId;
        this.clienteId = clienteId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
