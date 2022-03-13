package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.FabricaId;
import domain.moto.valueobject.MotoId;
import domain.moto.valueobject.NombreFabrica;
import domain.moto.valueobject.Representante;

public class CrearFabrica extends Command {
    private final MotoId motoId;
    private final FabricaId fabricaId;
    private final NombreFabrica nombre;
    private final Representante representante;

    public CrearFabrica(MotoId motoId, FabricaId fabricaId, NombreFabrica nombre, Representante representante) {
        this.motoId = motoId;
        this.fabricaId = fabricaId;
        this.nombre = nombre;
        this.representante = representante;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public NombreFabrica getNombre() {
        return nombre;
    }

    public Representante getRepresentante() {
        return representante;
    }
}
