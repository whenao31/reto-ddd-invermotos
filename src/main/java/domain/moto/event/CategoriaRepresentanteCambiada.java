package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.Representante;

public class CategoriaRepresentanteCambiada extends DomainEvent {
    private final Representante.Categoria categoria;

    public CategoriaRepresentanteCambiada(Representante.Categoria categoria) {
        super("moto.categoriarepresentantecambiada");
        this.categoria = categoria;
    }

    public Representante.Categoria getCategoria() {
        return categoria;
    }
}
