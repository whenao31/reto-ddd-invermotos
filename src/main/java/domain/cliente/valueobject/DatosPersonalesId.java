package domain.cliente.valueobject;

import co.com.sofka.domain.generic.Identity;

public class DatosPersonalesId extends Identity {
    private DatosPersonalesId(String valor) {
        super(valor);
    }

    public DatosPersonalesId(){}

    public static DatosPersonalesId of(String valor){
        return new DatosPersonalesId(valor);
    }
}
