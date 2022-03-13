package domain.cliente.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre,"No se puede tener nombre null");
    }

    @Override
    public String value() {
        return nombre;
    }
}
