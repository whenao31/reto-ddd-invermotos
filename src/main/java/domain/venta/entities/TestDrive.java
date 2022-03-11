package domain.venta.entities;

import co.com.sofka.domain.generic.Entity;
import domain.venta.valueobject.EstadoTestDrive;
import domain.venta.valueobject.Fecha;
import domain.venta.valueobject.TestDriveId;

public class TestDrive extends Entity<TestDriveId> {
    private Fecha fecha;
    private EstadoTestDrive estadoTestDrive;

    public TestDrive(TestDriveId entityId) {
        super(entityId);
        this.fecha = new Fecha();
        this.estadoTestDrive =  new EstadoTestDrive(EstadoTestDrive.Estado.PENDIENTE);
    }

    public void completarTestDrive(){
        this.estadoTestDrive = new EstadoTestDrive(EstadoTestDrive.Estado.COMPLETADO);
    }

    public void cancelarTestDrive(){
        this.estadoTestDrive = new EstadoTestDrive(EstadoTestDrive.Estado.CANCELADO);
    }

    public Fecha fecha() {
        return fecha;
    }

    public EstadoTestDrive estadoTestDrive() {
        return estadoTestDrive;
    }
}
