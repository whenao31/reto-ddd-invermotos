package domain.venta.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Dinero implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public Dinero(BigDecimal value) {
        this.value = Objects.requireNonNull(value, "El dinero no puede ser null");
    }

    @Override
    public BigDecimal value() {
        return value;
    }


}
