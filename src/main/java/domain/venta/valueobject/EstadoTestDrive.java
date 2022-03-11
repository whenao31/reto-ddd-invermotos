package domain.venta.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoTestDrive implements ValueObject<EstadoTestDrive.Estado> {
    private final EstadoTestDrive.Estado value;

    public EstadoTestDrive(EstadoTestDrive.Estado value) {
        this.value = value;
    }

    @Override
    public EstadoTestDrive.Estado value() {
        return value;
    }

    public enum Estado {
        SATISFECHO, NO_SATISFECHO
    }
}
