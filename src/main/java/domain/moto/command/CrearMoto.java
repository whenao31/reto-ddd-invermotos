package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.DisponibilidadMoto;
import domain.moto.valueobject.MotoId;

public class CrearMoto extends Command {
    private final MotoId motoId;
    private final DisponibilidadMoto disponibilidad;

    public CrearMoto(MotoId motoId, DisponibilidadMoto disponibilidad){
        this.motoId = motoId;
        this.disponibilidad = disponibilidad;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public DisponibilidadMoto getDisponibilidad() {
        return disponibilidad;
    }
}
