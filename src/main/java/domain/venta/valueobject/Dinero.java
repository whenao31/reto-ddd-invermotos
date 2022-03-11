package domain.venta.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Dinero implements ValueObject<BigDecimal> {

    public static final Dinero ZERO = new Dinero(BigDecimal.ZERO);

    private BigDecimal denomination;
    private String     currencyCode;

    protected Dinero() {
    }

    private Dinero(BigDecimal denomination) {
        this.denomination = denomination.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Dinero(double denomination) {
        this(new BigDecimal(denomination));
    }

    public Dinero multiplyBy(double multiplier) {
        return multiplyBy(new BigDecimal(multiplier));
    }

    public Dinero multiplyBy(BigDecimal multiplier) {
        return new Dinero(denomination.multiply(multiplier));
    }

    public Dinero add(Dinero dinero) {
        return new Dinero(denomination.add(dinero.denomination));
    }

    public Dinero subtract(Dinero dinero) {
        return new Dinero(denomination.subtract(dinero.denomination));
    }

    @Override
    public String toString() {
        return String.format("%0$.2f %s", denomination);
    }


    @Override
    public BigDecimal value() {
        return denomination;
    }
}
