package domain.venta.valueobject;

import co.com.sofka.domain.generic.Identity;

public class CotizacionId extends Identity {

    private CotizacionId(String valor){
        super(valor);
    }

    public CotizacionId(){}
    public static CotizacionId of(String valor){
        return new CotizacionId(valor);
    }
}
