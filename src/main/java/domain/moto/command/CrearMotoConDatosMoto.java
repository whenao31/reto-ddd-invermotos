package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.DatosMoto;
import domain.moto.valueobject.DisponibilidadMoto;
import domain.moto.valueobject.MotoId;

public class CrearMotoConDatosMoto extends Command {
    private final MotoId motoId;
    private final DatosMoto datosMoto;
    private final DisponibilidadMoto disponibilidad;

    public CrearMotoConDatosMoto(MotoId motoId, DatosMoto datosMoto, DisponibilidadMoto disponibilidad) {
        this.motoId = motoId;
        this.datosMoto = datosMoto;
        this.disponibilidad = disponibilidad;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public DatosMoto getDatosMoto() {
        return datosMoto;
    }

    public DisponibilidadMoto getDisponibilidad() {
        return disponibilidad;
    }
}
