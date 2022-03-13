package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.TestDriveId;
import domain.venta.valueobject.VentaId;

public class CancelarTestDrive extends Command {
    private final VentaId ventaId;
    private final TestDriveId testDriveId;

    public CancelarTestDrive(VentaId ventaId, TestDriveId testDriveId) {
        this.ventaId = ventaId;
        this.testDriveId = testDriveId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public TestDriveId getTestDriveId() {
        return testDriveId;
    }
}
