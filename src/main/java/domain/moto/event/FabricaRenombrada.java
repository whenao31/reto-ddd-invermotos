package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.NombreFabrica;

public class FabricaRenombrada extends DomainEvent {
    private final NombreFabrica nombre;

    public FabricaRenombrada(NombreFabrica nombre) {
        super("moto.fabricarenombrada");
        this.nombre = nombre;
    }

    public NombreFabrica getNombre() {
        return nombre;
    }
}
