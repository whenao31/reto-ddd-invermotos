package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.FabricaId;
import domain.moto.valueobject.NombreFabrica;
import domain.moto.valueobject.Representante;

public class FabricaCreada extends DomainEvent {
    private final FabricaId fabricaId;
    private final NombreFabrica nombre;
    private final Representante representante;

    public FabricaCreada(FabricaId fabricaIdId, NombreFabrica nombre, Representante representante) {
        super("moto.fabricacreada");
        this.fabricaId = fabricaIdId;
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
