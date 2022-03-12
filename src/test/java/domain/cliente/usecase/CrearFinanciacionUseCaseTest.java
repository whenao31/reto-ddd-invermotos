package domain.cliente.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.comand.CrearFinanciacion;
import domain.cliente.event.ClienteCreado;
import domain.cliente.event.FinanciacionCreada;
import domain.cliente.valueobject.*;
import domain.venta.comand.CrearFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearFinanciacionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearFinanciacion() {
        //Arrange
        ClienteId clienteId = ClienteId.of("clienteId1");
        FinanciacionId financiacionId = FinanciacionId.of("financiacionId1");
        BigDecimal tasaInteres =new BigDecimal("0.02");

        var command = new CrearFinanciacion(
                clienteId,
                financiacionId,
                new EstadoFinanciacion(EstadoFinanciacion.Estado.PENDIENTE),
                new Dinero(tasaInteres)
        );

        var usecase = new CrearFinanciacionUseCase();
        Mockito.when(repository.getEventsBy("clienteId1")).thenReturn(history());
        usecase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(clienteId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (FinanciacionCreada) events.get(0);
        Assertions.assertEquals("cliente.financiacioncreada", event.type);
        Assertions.assertEquals("financiacionId1",event.getFinanciacionId().value());
        Assertions.assertEquals(EstadoFinanciacion.Estado.PENDIENTE, event.getEstadoFinanciacion().value());
        Assertions.assertEquals(new BigDecimal("0.02"),event.getTasaInteres().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new ClienteCreado(ClienteId.of("clienteId1"), new Fecha())
        );
    }
}