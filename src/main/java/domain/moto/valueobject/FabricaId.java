package domain.moto.valueobject;

import co.com.sofka.domain.generic.Identity;

public class FabricaId extends Identity {
    private FabricaId(String valor) {
        super(valor);
    }

    public FabricaId(){}

    public static FabricaId of(String valor){
        return new FabricaId(valor);
    }
}
