package domain.moto;

import co.com.sofka.domain.generic.EventChange;
import domain.moto.event.*;

import java.util.HashMap;

public class MotoEventChange extends EventChange {
    public MotoEventChange(Moto moto) {

        apply((MotoCreada event) -> {
            moto.disponibilidad = event.getDisponibilidad();
            moto.datosMoto = null;
            moto.fabrica = null;
            moto.adicionales = new HashMap<>();
        });

        apply((MotoCreadaConDatos event) -> {
            moto.datosMoto = new DatosMoto(
                    event.getDatosMotoId(),
                    event.getModelo(),
                    event.getColor(),
                    event.getLinea()
                    );
            moto.disponibilidad = event.getDisponibilidadMoto();
            moto.fabrica = null;
            moto.adicionales = new HashMap<>();
        });

        apply((FabricaCreada event) -> {
            moto.fabrica = new Fabrica(event.getFabricaId(), event.getNombre(), event.getRepresentante());
        });

        apply((DatosMotoCreado event) -> {
            moto.datosMoto = new DatosMoto(event.getDatosMotoId(),
                    event.getModelo(),
                    event.getColor(),
                    event.getLinea()
            );
        });

        apply((AdicionalCreado event) -> {
            moto.adicionales.put(
                    event.getAdicionalId().value(),
                    new Adicional(event.getAdicionalId(), event.getEstado(), event.getDescripcion())
            );
        });

        apply((MotoPintada event) -> {
            moto.datosMoto.pintar(event.getColor());
        });

        apply((ModeloCambiado event) -> {
            moto.datosMoto.cambiarModelo(event.getModelo());
        });

        apply((LineaCambiada event) -> {
            moto.datosMoto.cambiarLinea(event.getLinea());
        });

        apply((FabricaRenombrada event) -> {
            moto.fabrica.renombrar(event.getNombre());
        });

        apply((CategoriaRepresentanteCambiada event) -> {
            moto.fabrica.cambiarCategoriaRepresentante(event.getCategoria());
        });

        apply((AdicionalInstalado event) -> {
            moto.adicionales.get(event.getAdicionalId().value()).instalarAdicional();
        });
    }
}
