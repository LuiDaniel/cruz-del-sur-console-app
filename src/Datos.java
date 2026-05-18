import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Datos {

    // Plantilla para crear las rutas
    public record Ruta(
            String origen,
            String destino,
            int duracion,
            double precio) {
    }

    // Plantilla para crear los buses
    public record Bus(
            String tipoBus,
            String asientos,
            double variacionPrecio) {
    }

    // Pasaje tendra todos los datos de bus, ruta y la fecha
    public record Pasaje(
            Bus bus,
            Ruta ruta,
            LocalDate fecha) {
    }

    // PAGOS
    public record Tarjeta(
        String numero,
        String titular,
        String vencimiento,
        String cvv) {
        // Constructor compacto para validaciones
        public Tarjeta {
            // 1. Validar número (16 dígitos numéricos)
            if (numero == null || !numero.matches("\\d{16}")) {
                throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos.");
            }
            // 2. Validar titular (No vacio y al menos nombre y apellido)
            if (titular == null || titular.trim().split("\\s+").length < 2) {
                throw new IllegalArgumentException("Ingrese el nombre completo del titular.");
            }
            // 3. Validar CVV (3 dígitos numericos)
            if (cvv == null || !cvv.matches("\\d{3}")) {
                throw new IllegalArgumentException("El CVV debe tener exactamente 3 dígitos.");
            }
            // 4. Validar Fecha de Vencimiento (Formato MM/AA y que no este vencida)
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
                YearMonth fechaVencimiento = YearMonth.parse(vencimiento, formatter);
                YearMonth mesActual = YearMonth.now();

                if (fechaVencimiento.isBefore(mesActual)) {
                    throw new IllegalArgumentException("La tarjeta ya está vencida.");
                }
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato de fecha inválido. Use MM/AA (Ej: 12/28).");
            }
        }
    }
    
    //BOLETA
    public record Boleta(
        String nombreEmpresa,
        String fraseEmpresa,
        String origen,
        String ruc,
        String tipoFactura,
        String servicio,
        String medioDePago
    ) {}

    // creamos un arreglo global de tipo Ruta
    static Ruta[] rutas = {
            // new Ruta(origen, destino, duracion, precio)
            new Ruta("Lima", "Arequipa", 16, 70.0),
            new Ruta("Arequipa", "Lima", 16, 70.0),
            new Ruta("Lima", "Cusco", 22, 120.0),
            new Ruta("Cusco", "Lima", 22, 120.0),
            new Ruta("Lima", "Huancayo", 7, 60.0),
            new Ruta("Huancayo", "Lima", 7, 60.0),
            new Ruta("Lima", "Tacna", 20, 140.0),
            new Ruta("Tacna", "Lima", 20, 140.0),
            new Ruta("Lima", "Puno", 21, 130.0),
            new Ruta("Puno", "Lima", 21, 130.0),
            new Ruta("Lima", "Ayacucho", 10, 80.0),
            new Ruta("Ayacucho", "Lima", 10, 80.0),
            new Ruta("Arequipa", "Juliaca", 5, 45.0),
            new Ruta("Juliaca", "Arequipa", 5, 45.0),
            new Ruta("Arequipa", "Tacna", 6, 55.0),
            new Ruta("Tacna", "Arequipa", 6, 55.0),
            new Ruta("Arequipa", "Cusco", 10, 80.0),
            new Ruta("Cusco", "Arequipa", 10, 80.0),
            new Ruta("Arequipa", "Moquegua", 3, 35.0),
            new Ruta("Moquegua", "Arequipa", 3, 35.0),
            new Ruta("Cusco", "Puno", 7, 75.0),
            new Ruta("Puno", "Cusco", 7, 75.0),
            new Ruta("Cusco", "Abancay", 4, 40.0),
            new Ruta("Abancay", "Cusco", 4, 40.0),
            new Ruta("Cusco", "Puerto Maldonado", 10, 90.0),
            new Ruta("Puerto Maldonado", "Cusco", 10, 90.0),
            new Ruta("Puno", "Juliaca", 1, 20.0),
            new Ruta("Juliaca", "Puno", 1, 20.0),
            new Ruta("Puno", "Tacna", 8, 65.0),
            new Ruta("Tacna", "Puno", 8, 65.0),
            new Ruta("Huancayo", "Ayacucho", 6, 50.0),
            new Ruta("Ayacucho", "Huancayo", 6, 50.0),
            new Ruta("Huancayo", "Huánuco", 7, 55.0),
            new Ruta("Huánuco", "Huancayo", 7, 55.0),
            new Ruta("Tacna", "Moquegua", 2, 30.0),
            new Ruta("Moquegua", "Tacna", 2, 30.0),
            new Ruta("Tacna", "Ilo", 2, 40.0),
            new Ruta("Ilo", "Tacna", 2, 40.0),
            new Ruta("Ayacucho", "Abancay", 8, 45.0),
            new Ruta("Abancay", "Ayacucho", 8, 45.0),
            new Ruta("Ayacucho", "Cusco", 12, 85.0),
            new Ruta("Cusco", "Ayacucho", 12, 85.0),
            new Ruta("Juliaca", "Cusco", 6, 70.0),
            new Ruta("Cusco", "Juliaca", 6, 70.0),
            new Ruta("Moquegua", "Ilo", 1, 25.0),
            new Ruta("Ilo", "Moquegua", 1, 25.0),
            new Ruta("Huánuco", "Lima", 9, 75.0),
            new Ruta("Lima", "Huánuco", 9, 75.0),
            new Ruta("Abancay", "Arequipa", 9, 60.0),
            new Ruta("Arequipa", "Abancay", 9, 60.0),
            new Ruta("Puerto Maldonado", "Puno", 12, 100.0),
            new Ruta("Puno", "Puerto Maldonado", 12, 100.0),
            new Ruta("Ilo", "Arequipa", 4, 50.0),
            new Ruta("Arequipa", "Ilo", 4, 50.0)
    };

    // areglo de buses
    public static Bus[] buses = {
            new Bus("Evolution", "160", 10),
            new Bus("Confort Suite", "180", 67),
            new Bus("Suite", "160", 47)
    };

}