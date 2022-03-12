package domain.moto.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.moto.Moto;
import domain.moto.event.AdicionalInstalado;
import domain.moto.valueobject.MotoId;

import java.util.List;

public class NotificarAdicionalInstaladoUseCase extends UseCase<TriggeredEvent<AdicionalInstalado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AdicionalInstalado> input) {
        var event = input.getDomainEvent();
        var service = getService(SMSService.class).orElseThrow();

        var events = repository().getEventsBy("moto", event.aggregateRootId());
//        System.out.println(event.aggregateRootId());
        var moto = Moto.from(MotoId.of(event.aggregateRootId()), events);
        var isOK = service.enviarMensajeAFabrica(
                moto.fabrica().identity(),
                String.format("Adicional %s instalado", event.getAdicionalId())
        );
        if(isOK){
            emit().onResponse(new ResponseEvents(List.of()));
        }else{
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar SMS");
        }
    }
}
