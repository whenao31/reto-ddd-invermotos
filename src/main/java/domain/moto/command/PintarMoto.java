package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.Color;
import domain.moto.valueobject.MotoId;

public class PintarMoto extends Command {
    private final MotoId motoId;
    private final Color color;

    public PintarMoto(MotoId motoId, Color color) {
        this.motoId = motoId;
        this.color = color;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public Color getColor() {
        return color;
    }
}
