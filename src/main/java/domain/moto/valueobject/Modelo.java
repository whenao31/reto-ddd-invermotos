package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Modelo implements ValueObject<Integer> {

    private final Integer value;

    public Modelo(Integer value){
        this.value = Objects.requireNonNull(value);
        if (validarModelo()){
            throw new IllegalArgumentException("El año debe ser el actual o el siguiente al actual");
        }
    }

    private boolean validarModelo(){
        return this.value < LocalDate.now().getYear() && this.value > LocalDate.now().getYear() + 1;
    }

    @Override
    public  Integer value(){
        return value;
    }
}
