package domain.moto.command;

import co.com.sofka.domain.generic.Command;
import domain.moto.valueobject.FabricaId;
import domain.moto.valueobject.NombreFabrica;
import domain.moto.valueobject.Representante;

public class CrearFabrica extends Command {
    private final FabricaId fabricaId;
    private final NombreFabrica nombre;
    private final Representante representante;

    public CrearFabrica(FabricaId fabricaId, NombreFabrica nombre, Representante representante) {
        this.fabricaId = fabricaId;
        this.nombre = nombre;
        this.representante = representante;
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
