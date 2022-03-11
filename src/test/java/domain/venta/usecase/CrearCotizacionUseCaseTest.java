package domain.venta.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.comand.CrearCotizacion;
import domain.venta.event.CotizacionCreada;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.CotizacionId;
import domain.venta.valueobject.MotoId;
import domain.venta.valueobject.VentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearCotizacionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearCotizacion() {

        //Arrange
        VentaId ventaId = VentaId.of("ventaId1");
        CotizacionId cotizacionId = CotizacionId.of("cotizacionId1");

        var command = new CrearCotizacion(
                ventaId,
                cotizacionId
        );

        var usecase= new CrearCotizacionUseCase();
        Mockito.when(repository.getEventsBy("ventaId1")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CotizacionCreada) events.get(0);
        Assertions.assertEquals("venta.cotizacioncreada", event.type);
        Assertions.assertEquals("cotizacionId1", event.getCotizacionId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(MotoId.of("motoId1"), ClienteId.of("clienteId1"))
        );
    }
}