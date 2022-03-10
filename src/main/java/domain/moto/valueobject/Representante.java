package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Representante implements ValueObject<Representante.Props> {

    private final Categoria categoria;
    private final String nombre;

    public Representante(Categoria categoria, String nombre) {
        this.categoria = categoria;
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.length() < 5){
            throw new IllegalArgumentException("Nombre del Representante debe tener mas de 5 caracteres");
        }
    }

    public Representante() {
        this(Categoria.BRONCE,"Representante1");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Categoria categoria() {
                return categoria;
            }

            @Override
            public String nombre() {
                return nombre;
            }
        };
    }

    public enum Categoria{
        BRONCE, PLATA, PLATINUM, DIAMANTE
    }

    public interface Props {
        Categoria categoria();
        String nombre();
    }
}