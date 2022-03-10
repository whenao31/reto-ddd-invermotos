package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class Color implements ValueObject<Color.Opcion> {
    private final Color.Opcion value;

    public Color(Color.Opcion value) {
        this.value = value;
    }

    @Override
    public Color.Opcion value() {
        return value;
    }

    public enum Opcion {
        PLATA, NEGRO, BLANCO_PERLADO, ROJO_PERLADO
    }
}
