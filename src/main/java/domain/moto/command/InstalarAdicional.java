package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.AdicionalId;
import domain.moto.valueobject.MotoId;

public class InstalarAdicional extends Command {
    private final MotoId motoId;
    private final AdicionalId adicionalId;

    public InstalarAdicional(MotoId motoId, AdicionalId adicionalId) {
        this.motoId = motoId;
        this.adicionalId = adicionalId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public AdicionalId getAdicionalId() {
        return adicionalId;
    }
}
