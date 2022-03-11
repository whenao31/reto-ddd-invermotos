package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.CotizacionId;
import domain.venta.valueobject.Dinero;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.VentaId;

public class CrearCotizacion extends Command {
    private final VentaId      ventaId;
    private final CotizacionId cotizacionId;

    public CrearCotizacion(VentaId ventaId, CotizacionId cotizacionId) {
        this.ventaId = ventaId;
        this.cotizacionId = cotizacionId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

}
