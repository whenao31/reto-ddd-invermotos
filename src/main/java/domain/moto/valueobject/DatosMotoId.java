package domain.moto.valueobject;

import co.com.sofka.domain.generic.Identity;

public class DatosMotoId extends Identity {
    private DatosMotoId(String valor) {
        super(valor);
    }

    public DatosMotoId(){}

    public static DatosMotoId of(String valor){
        return new DatosMotoId(valor);
    }
}
