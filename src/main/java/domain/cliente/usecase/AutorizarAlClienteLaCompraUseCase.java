package domain.cliente.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cliente.Cliente;
import domain.cliente.event.FinanciacionAprobada;
import domain.cliente.valueobject.ClienteId;

import java.util.List;

public class AutorizarAlClienteLaCompraUseCase extends UseCase<TriggeredEvent<FinanciacionAprobada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<FinanciacionAprobada> input) {
        var event = input.getDomainEvent();
        var service = getService(AutorizacionService.class).orElseThrow();

        var events = repository().getEventsBy("cliente",event.aggregateRootId());

        var cliente = Cliente.from(ClienteId.of(event.aggregateRootId()),events);

        System.out.println(cliente.datosPersonales().nombre());

        var esAutorizado = service.autorizarCompraACliente(
                cliente.datosPersonales().identity(),
                "Cliente Autorizado"
        );
        if(esAutorizado){
            emit().onResponse(new ResponseEvents(List.of()));
        }else {
            throw new BusinessException(event.aggregateRootId(), "No se pudo autorizar la compra");
        }


    }
}
