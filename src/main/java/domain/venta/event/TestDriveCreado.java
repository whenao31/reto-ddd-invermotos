package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.TestDriveId;

public class TestDriveCreado extends DomainEvent {
    private final TestDriveId testDriveId;

    public TestDriveCreado(TestDriveId testDriveId) {
        super("venta.testdrivecreado");
        this.testDriveId = testDriveId;
    }

    public TestDriveId getTestDriveId() {
        return testDriveId;
    }
}
