package domain.venta.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.comand.CrearTestDrive;
import domain.venta.event.TestDriveCreado;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CrearTestDriveUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearTestDrive() {
        //Arrange
        VentaId ventaId = VentaId.of("ventaId1");
        TestDriveId testDriveId = TestDriveId.of("testDriveId3");

        var command = new CrearTestDrive(ventaId,testDriveId);

        var usecase = new CrearTestDriveUseCase();
        Mockito.when(repository.getEventsBy("ventaId1")).thenReturn(history());
        usecase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (TestDriveCreado) events.get(0);
        Assertions.assertEquals("venta.testdrivecreado",event.type);
        Assertions.assertEquals("testDriveId3", event.getTestDriveId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(MotoId.of("motoId1"), ClienteId.of("clientId1")),
                new TestDriveCreado(TestDriveId.of("testDrive1")),
                new TestDriveCreado(TestDriveId.of("testDrive2"))
        );
    }
}