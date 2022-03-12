package domain.cliente.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoFinanciacion implements ValueObject<EstadoFinanciacion.Estado> {
    private final EstadoFinanciacion.Estado value;

    public EstadoFinanciacion(Estado value) {
        this.value = value;
    }

    @Override
    public EstadoFinanciacion.Estado value() {
        return value;
    }

    public enum Estado {
        APROBADO, NO_APROBADO, PENDIENTE
    }
}
