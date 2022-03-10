package domain.moto;

import co.com.sofka.domain.generic.Entity;
import domain.moto.valueobject.FabricaId;
import domain.moto.valueobject.NombreFabrica;
import domain.moto.valueobject.Representante;

public class Fabrica extends Entity<FabricaId> {
    private NombreFabrica nombre;
    private Representante representante;


    public Fabrica(FabricaId entityId) {
        super(entityId);
        this.nombre = new NombreFabrica();
        this.representante = new Representante();
    }

    public Fabrica(FabricaId entityId, NombreFabrica nombre, Representante representante) {
        super(entityId);
        this.nombre = nombre;
        this.representante = representante;
    }

    public void renombrar(NombreFabrica nombre){
        this.nombre = nombre;
    }

    public void cambiarCategoriaRepresentante(Representante.Categoria categoria){
        representante = new Representante(categoria, representante.value().nombre());
    }

    public NombreFabrica nombre() {
        return nombre;
    }

    public Representante representante() {
        return representante;
    }
}
