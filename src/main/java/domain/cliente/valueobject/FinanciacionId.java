package domain.cliente.valueobject;

import co.com.sofka.domain.generic.Identity;

public class FinanciacionId extends Identity {
    private FinanciacionId(String valor) {
        super(valor);
    }

    public FinanciacionId(){}

    public static FinanciacionId of(String valor){
        return new FinanciacionId(valor);
    }
}
