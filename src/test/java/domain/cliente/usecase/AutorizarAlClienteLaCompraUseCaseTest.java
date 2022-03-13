package domain.cliente.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.event.*;
import domain.cliente.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AutorizarAlClienteLaCompraUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private AutorizacionService service;

    @Test
    void autorizarAlClienteLaCompra() {
        var event = new FinanciacionAprobada(FinanciacionId.of("financiacionId1"));

        event.setAggregateRootId("clienteId1");

        var useCase = new AutorizarAlClienteLaCompraUseCase();
        Mockito.when(repository.getEventsBy("cliente","clienteId1")).thenReturn(history());
        Mockito.when(service.autorizarCompraACliente(
                Mockito.any(DatosPersonalesId.class),
                Mockito.anyString())).thenReturn(true);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("clienteId1")
                .syncExecutor(useCase, new TriggeredEvent<>(event)).isPresent();
        Assertions.assertTrue(isPresent);

    }

    private List<DomainEvent> history() {
        return List.of(
                new ClienteCreado(ClienteId.of("clienteId1"),new Fecha()),
                new DatosPersonalesCreados(DatosPersonalesId.of("datosPId1"), new Nombre("Camilo")),
                new FinanciacionCreada(
                        FinanciacionId.of("financiacionId1"),
                        new EstadoFinanciacion(EstadoFinanciacion.Estado.PENDIENTE),
                        new Dinero(0.02))
        );
    }
}