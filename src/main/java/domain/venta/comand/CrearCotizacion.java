package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.CotizacionId;
import domain.venta.valueobject.Dinero;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.VentaId;

public class CrearCotizacion extends Command {
    private final VentaId      ventaId;
    private final CotizacionId cotizacionId;
    private final Fecha fecha;
    private final Dinero costoTotal;

    public CrearCotizacion(VentaId ventaId, CotizacionId cotizacionId, Fecha fecha, Dinero costoTotal) {
        this.ventaId = ventaId;
        this.cotizacionId = cotizacionId;
        this.fecha = fecha;
        this.costoTotal = costoTotal;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Dinero getCostoTotal() {
        return costoTotal;
    }
}
