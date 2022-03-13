package domain.cliente.usecase;

import domain.cliente.valueobject.DatosPersonalesId;

public interface AutorizacionService {
    boolean autorizarCompraACliente(DatosPersonalesId datosPersonalesId, String mensaje);
}
