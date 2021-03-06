package domain.cliente.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class PuntajeCrediticio implements ValueObject<PuntajeCrediticio.Puntaje> {
    private final PuntajeCrediticio.Puntaje value;

    public PuntajeCrediticio(Puntaje value) {
        this.value = value;
    }

    public PuntajeCrediticio(){
        this.value = Puntaje.ESTUDIO;
    }

    @Override
    public PuntajeCrediticio.Puntaje value() {
        return value;
    }

    public enum Puntaje {
        NEGATIVO, POSITIVO, ESTUDIO
    }
}
