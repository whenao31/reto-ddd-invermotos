package domain.venta.valueobject;

import co.com.sofka.domain.generic.Identity;

public class VentaId extends Identity {
    private VentaId(String valor){
        super(valor);
    }

    public VentaId(){}
    public static VentaId of(String valor){
        return new VentaId(valor);
    }

}
