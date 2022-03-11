package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class DisponibilidadMoto implements ValueObject<DisponibilidadMoto.Estado> {
    private final Estado value;

    public DisponibilidadMoto(Estado value) {
        this.value = value;
    }

    @Override
    public Estado value() {
        return value;
    }


    public enum Estado{
        DISPONIBLE, NO_DISPONIBLE
    }
}
