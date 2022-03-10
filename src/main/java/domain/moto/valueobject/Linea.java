package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Linea implements ValueObject<String> {
    private final String linea;

    public Linea() {
        this("");
    }

    public Linea(String value) {
        this.linea = Objects.requireNonNull(value);
        if (this.linea.length() < 5){
            throw new IllegalArgumentException("Linea de Moto debe tener mas de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return linea;
    }
}
