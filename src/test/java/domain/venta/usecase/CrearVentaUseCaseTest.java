package domain.venta.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.venta.comand.CrearVenta;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.MotoId;
import domain.venta.valueobject.VentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearVentaUseCaseTest {

    @Test
    void crearVenta() {
        //Arrange
        VentaId ventaId = VentaId.of("ventaId1");
        MotoId motoId = MotoId.of("motoId1");
        ClienteId clienteId = ClienteId.of("clienteId1");

        CrearVenta crearVenta = new CrearVenta(ventaId,motoId,clienteId);

        //Act
        CrearVentaUseCase useCase = new CrearVentaUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearVenta))
                .orElseThrow()
                .getDomainEvents();

        //Asset
        var event = (VentaCreada) events.get(0);
        Assertions.assertEquals("venta.ventacreada", event.type);
        Assertions.assertEquals("ventaId1", event.aggregateRootId());
        Assertions.assertEquals("motoId1", event.getMotoId().value());
        Assertions.assertEquals("clienteId1", event.getClienteId().value());
    }

}