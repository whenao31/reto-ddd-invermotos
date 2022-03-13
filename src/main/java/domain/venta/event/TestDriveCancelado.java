package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.TestDriveId;

public class TestDriveCancelado extends DomainEvent {
    private final TestDriveId testDriveId;

    public TestDriveCancelado(TestDriveId testDriveId) {
        super("venta.testdrivecancelado");
        this.testDriveId = testDriveId;
    }

    public TestDriveId getTestDriveId() {
        return testDriveId;
    }
}
