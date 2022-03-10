package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion() {
        this("");
    }

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
        if (descripcion.length() < 5){
            throw new IllegalArgumentException("Descripcion de adicional debe tener mas de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return descripcion;
    }
}
