package domain.venta.comand;

import co.com.sofka.domain.generic.Command;
import domain.venta.valueobject.ClienteId;
import domain.venta.valueobject.MotoId;
import domain.venta.valueobject.VentaId;

public class CrearVenta extends Command {
    private VentaId   ventaId;
    private MotoId    motoId;
    private ClienteId clienteId;

}
