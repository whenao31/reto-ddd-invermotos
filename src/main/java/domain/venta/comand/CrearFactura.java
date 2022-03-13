package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.FacturaId;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.VendedorId;
import domain.venta.valueobject.VentaId;

public class CrearFactura extends Command {
    private final VentaId    ventaId;
    private final FacturaId  facturaId;
    private final VendedorId vendedorId;

    public CrearFactura(VentaId ventaId, FacturaId facturaId, VendedorId vendedorId) {
        this.ventaId = ventaId;
        this.facturaId = facturaId;

        this.vendedorId = vendedorId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }


    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
