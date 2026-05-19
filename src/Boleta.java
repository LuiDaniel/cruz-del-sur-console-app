import java.time.LocalDate;
import java.util.Locale;

public class Boleta {
    public static Datos.Boleta generarBoleta(Datos.Cliente cliente, Datos.Pasaje pasaje) {

        String ruta = pasaje.ruta().origen() + " --> " + pasaje.ruta().destino(); // Ruta Completa
        LocalDate fecha = LocalDate.now();// Fecha Actual
        double subtotal = pasaje.ruta().precio() + pasaje.bus().variacionPrecio();// Subtotal
        double igv = subtotal * 0.18;// IGV 18%
        double total = subtotal + igv;// Total

        Datos.Boleta boleta = new Datos.Boleta(
                pasaje.ruta().origen(),
                "1234",
                cliente.dni(),
                cliente.nombres(),
                cliente.correo(),
                ruta,
                pasaje.bus().tipoBus(),
                fecha,
                subtotal,
                igv,
                0.0,
                total,
                null, 
                pasaje.ruta().origen());

        return boleta;
    }
}
