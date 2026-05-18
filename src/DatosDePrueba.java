import java.time.LocalDate;

public class DatosDePrueba{

    public record PasajePrueba(
        Datos.Bus bus,
        Datos.Ruta ruta,
        LocalDate fecha
    ){}

    static Datos.Bus bus = Datos.buses[1];
    static Datos.Ruta ruta = Datos.rutas[1];

    static PasajePrueba pasaje1 = new PasajePrueba(bus, ruta, LocalDate.now());
}
