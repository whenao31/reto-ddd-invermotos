package domain.venta.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.valueobject.TestDriveId;

public class TestDriveCompletado extends DomainEvent {
    private final TestDriveId testDriveId;

    public TestDriveCompletado(TestDriveId testDriveId) {
        super("venta.testdrivecompletado");
        this.testDriveId = testDriveId;
    }

    public TestDriveId getTestDriveId() {
        return testDriveId;
    }
}
