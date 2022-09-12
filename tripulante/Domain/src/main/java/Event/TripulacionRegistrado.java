package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class TripulacionRegistrado extends DomainEvent {

    public UUID KeyTripulacion;
    public String Nombre;

    public TripulacionRegistrado(UUID key, String nombre) {
        super(LocalDateTime.now());
        KeyTripulacion = key;
        Nombre = nombre;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
