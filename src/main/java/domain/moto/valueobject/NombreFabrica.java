package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreFabrica implements ValueObject<String> {
    private final String value;

    public NombreFabrica() {
        this("");
    }

    public NombreFabrica(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.length() < 5){
            throw new IllegalArgumentException("Nombre de Fabrica debe tener mas de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
