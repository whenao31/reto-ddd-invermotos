package domain.venta.valueobject;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
    private FacturaId(String valor){
        super(valor);
    }

    public FacturaId(){}
    public static FacturaId of(String valor){
        return new FacturaId(valor);
    }
}

