package domain.venta.valueobject;

import co.com.sofka.domain.generic.Identity;

public class MotoId extends Identity {
    private MotoId(String valor) {
        super(valor);
    }

    public MotoId(){}

    public static MotoId of(String valor){
        return new MotoId(valor);
    }
}
