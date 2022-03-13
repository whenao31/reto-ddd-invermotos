package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.AdicionalId;

public class AdicionalInstalado extends DomainEvent {
    public final AdicionalId adicionalId;

    public AdicionalInstalado(AdicionalId adicionalId) {
        super("moto.adicionalinstalado");
        this.adicionalId = adicionalId;
    }

    public AdicionalId getAdicionalId() {
        return adicionalId;
    }
}
