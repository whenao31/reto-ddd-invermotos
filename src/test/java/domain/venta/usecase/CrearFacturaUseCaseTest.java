package domain.venta.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.Venta;
import domain.venta.comand.CrearFactura;
import domain.venta.event.FacturaCreada;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearFactura() {
        //Arrange
        VentaId ventaId = VentaId.of("ventaId1");
        FacturaId facturaId = FacturaId.of("facturaId1");
        VendedorId vendedorId = VendedorId.of("vendedorId1");
        var command = new CrearFactura(
                ventaId,
                facturaId,
                vendedorId
        );

        var usecase = new CrearFacturaUseCase();
        Mockito.when(repository.getEventsBy("ventaId1")).thenReturn(history());
        usecase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (FacturaCreada) events.get(0);
        Assertions.assertEquals("venta.facturacreada", event.type);
        Assertions.assertEquals("facturaId1",event.getFacturaId().value());
        Assertions.assertEquals("vendedorId1",event.getVendedorId().value());

    }

    private List<DomainEvent> history(){
        return List.of(
                new VentaCreada(MotoId.of("motoId1"), ClienteId.of("clienteId1"))
        );
    }
}