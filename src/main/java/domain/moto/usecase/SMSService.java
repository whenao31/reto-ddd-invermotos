package domain.moto.usecase;

import domain.moto.valueobject.FabricaId;

public interface SMSService {
    boolean enviarMensajeAFabrica(FabricaId fabricaId, String mensaje);
}
