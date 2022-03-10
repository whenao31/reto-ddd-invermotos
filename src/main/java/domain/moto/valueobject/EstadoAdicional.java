package domain.moto.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoAdicional implements ValueObject<EstadoAdicional.Fase> {
private final Fase value;

public EstadoAdicional(Fase value) {
        this.value = value;
        }

@Override
public Fase value() {
        return value;
        }

public enum Fase {
    INSTALADO, PENDIENTE
}
}