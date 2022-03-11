package domain.venta.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public Fecha() {
        this.value = LocalDateTime.now();
    }

    public Fecha(String fechaString){
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            localDateTime = Objects
                    .requireNonNull(LocalDateTime.parse(fechaString, formatter),"fechaString not null");
        }catch(Exception e){
            System.out.println("Formato de fecha no valido");
        }
        this.value = localDateTime;
    }

    @Override
    public LocalDateTime value() {
        return value;
    }
}
