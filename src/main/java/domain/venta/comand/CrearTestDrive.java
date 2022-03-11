package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.EstadoTestDrive;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.VentaId;

public class CrearTestDrive extends Command {
    private final VentaId ventaId;
    private final Fecha   fecha;
    private final EstadoTestDrive estadoTestDrive;

    public CrearTestDrive(VentaId ventaId, Fecha fecha, EstadoTestDrive estadoTestDrive) {
        this.ventaId = ventaId;
        this.fecha = fecha;
        this.estadoTestDrive = estadoTestDrive;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public EstadoTestDrive getEstadoTestDrive() {
        return estadoTestDrive;
    }
}
