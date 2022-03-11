package domain.moto;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.moto.event.*;
import domain.moto.valueobject.*;

import java.util.List;
import java.util.Map;

public class Moto extends AggregateEvent<MotoId> {
    protected DatosMoto datosMoto;
    protected Fabrica fabrica;
    protected Map<String, Adicional> adicionales;
    protected DisponibilidadMoto disponibilidad;

    public Moto(MotoId motoId, DisponibilidadMoto disponibilidad) {
        super(motoId);
        appendChange(new MotoCreada(disponibilidad)).apply();
        subscribe(new MotoEventChange(this));
    }

    public Moto(MotoId motoId, DatosMoto datosMoto, DisponibilidadMoto disponibilidad) {
        super(motoId);
        appendChange(new MotoCreadaConDatos(datosMoto, disponibilidad)).apply();
        subscribe(new MotoEventChange(this));
    }

    //    constructor privado que es usado por el metodo "form()"
    private Moto(MotoId motoId){
        super(motoId);
        subscribe(new MotoEventChange(this));
    }

//    Metodo para reconstruir el estado del agregado a partir de los eventos guardados
    private static Moto from(MotoId motoId, List<DomainEvent> events){
        var moto = new Moto(motoId);
        events.forEach(moto::applyEvent);
        return moto;
    }

    public void crearDatosMoto(DatosMotoId datosMotoId, Modelo modelo, Color color, Linea linea){
        appendChange(new DatosMotoCreado(datosMotoId, modelo, color, linea)).apply();
    }

    public void crearFabrica(FabricaId fabricaIdId, NombreFabrica nombre, Representante representante){
        appendChange(new FabricaCreada(fabricaIdId, nombre, representante)).apply();
    }

    public void crearAdicional(AdicionalId adicionalId, EstadoAdicional estado, Descripcion descripcion){
        appendChange(new AdicionalCreado(adicionalId, estado, descripcion)).apply();
    }

    public void pintar(Color.Opcion color){
        appendChange(new MotoPintada(color)).apply();
    }

    public void cambiarModelo(Modelo modelo){
        appendChange(new ModeloCambiado(modelo)).apply();
    }

    public void cambiarLinea(Linea linea){
        appendChange(new LineaCambiada(linea)).apply();
    }

    public void renombrarFabrica(NombreFabrica nombre){
        appendChange(new FabricaRenombrada(nombre)).apply();
    }

    public void cambiarCategoriaRepresentante(Representante.Categoria categoria){
        appendChange(new CategoriaRepresentanteCambiada(categoria)).apply();
    }

    public void instalarAdicional(AdicionalId adicionalId){
        appendChange(new AdicionalInstalado(adicionalId)).apply();
    }

    public Map<String, Adicional> adicionales(){return adicionales;}
}
