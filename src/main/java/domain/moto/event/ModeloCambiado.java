package domain.moto.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.valueobject.Modelo;

public class ModeloCambiado extends DomainEvent {
    private final Modelo modelo;
    public ModeloCambiado(Modelo modelo) {
        super("moto.modelocambiado");
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }
}
