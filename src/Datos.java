import java.time.LocalDate;

public class Datos {

    //Plantilla para crear las rutas  
    public record Ruta(
            String origen,
            String destino,
            double precio) {
    }
    //creamos un arreglo global de tipo Ruta
    static Ruta[] rutas = {
            new Ruta("Lima", "Arequipa", 70),
            new Ruta("Arequipa", "Lima", 70),
            new Ruta("Lima", "Cusco", 120),
            new Ruta("Cusco", "Lima", 120),
            new Ruta("Lima", "Huancayo", 60),
            new Ruta("Huancayo", "Lima", 60),
            new Ruta("Lima", "Tacna", 140),
            new Ruta("Tacna", "Lima", 140),
            new Ruta("Lima", "Puno", 130),
            new Ruta("Puno", "Lima", 130),
            new Ruta("Lima", "Ayacucho", 80),
            new Ruta("Ayacucho", "Lima", 80),
            new Ruta("Arequipa", "Juliaca", 45),
            new Ruta("Juliaca", "Arequipa", 45),
            new Ruta("Arequipa", "Tacna", 55),
            new Ruta("Tacna", "Arequipa", 55),
            new Ruta("Arequipa", "Cusco", 80),
            new Ruta("Cusco", "Arequipa", 80),
            new Ruta("Arequipa", "Moquegua", 35),
            new Ruta("Moquegua", "Arequipa", 35),
            new Ruta("Cusco", "Puno", 75),
            new Ruta("Puno", "Cusco", 75),
            new Ruta("Cusco", "Abancay", 40),
            new Ruta("Abancay", "Cusco", 40),
            new Ruta("Cusco", "Puerto Maldonado", 90),
            new Ruta("Puerto Maldonado", "Cusco", 90),
            new Ruta("Puno", "Juliaca", 20),
            new Ruta("Juliaca", "Puno", 20),
            new Ruta("Puno", "Tacna", 65),
            new Ruta("Tacna", "Puno", 65),
            new Ruta("Huancayo", "Ayacucho", 50),
            new Ruta("Ayacucho", "Huancayo", 50),
            new Ruta("Huancayo", "Huánuco", 55),
            new Ruta("Huánuco", "Huancayo", 55),
            new Ruta("Tacna", "Moquegua", 30),
            new Ruta("Moquegua", "Tacna", 30),
            new Ruta("Tacna", "Ilo", 40),
            new Ruta("Ilo", "Tacna", 40),
            new Ruta("Ayacucho", "Abancay", 45),
            new Ruta("Abancay", "Ayacucho", 45),
            new Ruta("Ayacucho", "Cusco", 85),
            new Ruta("Cusco", "Ayacucho", 85),
            new Ruta("Juliaca", "Cusco", 70),
            new Ruta("Cusco", "Juliaca", 70),
            new Ruta("Moquegua", "Ilo", 25),
            new Ruta("Ilo", "Moquegua", 25),
            new Ruta("Huánuco", "Lima", 75),
            new Ruta("Lima", "Huánuco", 75),
            new Ruta("Abancay", "Arequipa", 60),
            new Ruta("Arequipa", "Abancay", 60),
            new Ruta("Puerto Maldonado", "Puno", 100),
            new Ruta("Puno", "Puerto Maldonado", 100),
            new Ruta("Ilo", "Arequipa", 50),
            new Ruta("Arequipa", "Ilo", 50)
    };

    //tipos de buses
    public record Bus(
        String tipoBus,
        String asientos,
        double variacionPrecio

    ) {}

    public static Bus[] buses = {
        new Bus("Evolution", "160", 10),
        new Bus("Confort Suite", "180", 67),
        new Bus("Suite", "160", 47)
    };

    public record Pasaje(
        Bus bus,
        Ruta ruta,
        LocalDate fecha
    ) {}
}