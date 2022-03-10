package domain.moto.valueobject;

import co.com.sofka.domain.generic.Identity;

public class AdicionalId extends Identity {
    private AdicionalId(String valor) {
        super(valor);
    }

    public AdicionalId() {
    }

    public static AdicionalId of(String valor) {
        return new AdicionalId(valor);
    }
}