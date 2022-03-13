package domain.venta.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.comand.CancelarTestDrive;
import domain.venta.event.TestDriveCancelado;
import domain.venta.event.TestDriveCompletado;
import domain.venta.event.TestDriveCreado;
import domain.venta.event.VentaCreada;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.MotoId;
import domain.venta.valueobject.TestDriveId;
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
class CancelarTestDriveUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cancelarTestDrive(){
        //        Arrange
        VentaId ventaId = VentaId.of("ventaId1");
        TestDriveId testDriveId = TestDriveId.of("testDriveId1");

        var command = new CancelarTestDrive(ventaId, testDriveId);

        var useCase = new CancelarTestDriveUseCase();
        Mockito.when(repository.getEventsBy("ventaId1")).thenReturn(history());
        useCase.addRepository(repository);
//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        Assert
        var event = (TestDriveCancelado) events.get(0);
        Assertions.assertEquals("venta.testdrivecancelado", event.type);
        Assertions.assertEquals("testDriveId1", event.getTestDriveId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(MotoId.of("motoId1"), ClienteId.of("clienteId1")),
                new TestDriveCreado(TestDriveId.of("testDriveId1")),
//                new TestDriveCompletado(TestDriveId.of("testDriveId1")),
                new TestDriveCreado(TestDriveId.of("testDriveId2")),
                new TestDriveCreado(TestDriveId.of("testDriveId3"))
        );
    }
}