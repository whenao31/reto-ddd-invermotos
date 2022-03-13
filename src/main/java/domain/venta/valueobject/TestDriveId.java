package domain.venta.valueobject;

import co.com.sofka.domain.generic.Identity;

public class TestDriveId extends Identity {
    private TestDriveId(String valor){
        super(valor);
    }

    public TestDriveId(){}
    public static TestDriveId of(String valor){
        return new TestDriveId(valor);
    }
}
