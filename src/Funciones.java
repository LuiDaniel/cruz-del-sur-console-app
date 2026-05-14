import java.util.Scanner;
import java.time.LocalDate;

public class Funciones {
    static Scanner sc = new Scanner(System.in);

    // Seleccionar origen
    public static String elegirOrigen() {
        System.out.println("-----ORIGENES-----");
        // Iteramos el arreglo de rutas
        for (int i = 0; i < Datos.rutas.length; i++) {
            System.out.println(
                    (i + 1) + ". " + Datos.rutas[i].origen());
        }
        System.out.println("Seleccione origen: ");
        int opcion = sc.nextInt();
        // devuelve el origen de la ruta seleccionada en String
        return Datos.rutas[opcion - 1].origen();
    }

    // Seleccionar Destino
    public static String elegirDestino(String origen) {
        System.out.println("-----DESTINOS-----");
        // Iteramos el arreglo de rutas
        for (int i = 0; i < Datos.rutas.length; i++) {
            // Validamos el origen ingresado para mostrar solo sus destinos disponibles
            if (origen.equalsIgnoreCase(Datos.rutas[i].origen())) { // new Ruta("Lima", "Arequipa", 70),
                System.out.println((i + 1) + ". " + Datos.rutas[i].destino());
            }
        }
        System.out.println("Seleccione destino: ");
        int opcion = sc.nextInt();
        // retornamos el destino de la ruta seleccionada en String
        return Datos.rutas[opcion - 1].destino();
    }

    // Seleccionar Fecha
    public static LocalDate elegirFecha() {
        System.out.println("¿Cuándo viajas?");
        System.out.println("1. Hoy");
        System.out.println("2. Mañana");
        System.out.println("3. Elegir");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            return LocalDate.now(); // devuelve la fecha actual
        } else if (opcion == 2) {
            return LocalDate.now().plusDays(1); // agrega un dia a la fecha actual
        } else if (opcion == 3) {
            System.out.println("Dia: ");
            int dia = sc.nextInt();
            LocalDate hoy = LocalDate.now(); // obtenemos la fecha actual
            return LocalDate.of(2026, hoy.getMonth(), dia); // devuelve la fecha seleccionada
        }
        return null;
    }

    // Guardar ruta Seleccionada, Tipo de dato: Ruta
    public static Datos.Ruta devolverRutaSeleccionada(String origen, String destino) {
        // Iteramos todo el array de rutas hasta encontra una ruta que coincida con el
        // origen y destino seleccionado
        for (int i = 0; i < Datos.rutas.length; i++) {
            if (origen.equalsIgnoreCase(Datos.rutas[i].origen())
                    && destino.equalsIgnoreCase(Datos.rutas[i].destino())) {
                return Datos.rutas[i];
            }
        }
        return null;
    }

    // Pasaje seleccionado, Devuelve un dato de tipo Pasaje
    public static Datos.Pasaje pasaje(Datos.Ruta ruta, Datos.Bus bus, LocalDate fecha) {
        return new Datos.Pasaje(bus, ruta, fecha);
        /*Retorna un dato de tipo Pasaje:
        Ruta:
            origen,
            destino,
            precio
        Bus:
            tipoBus,
            Asiento,
            VariacionPrecio
        fecha, */
    }

    // Mostrar Buses Disponibles
    public static Datos.Bus mostrarBuses(Datos.Bus[] buses,Datos.Ruta ruta, LocalDate fecha){
        int opcion;
        do{
            System.out.println("------Viajes recomendados para ti-----");
        for(int i = 0; i < Datos.buses.length; i++){
            double precioFinal = ruta.precio() + buses[i].variacionPrecio();
            System.out.println(
            (i + 1) + ". " + buses[i].tipoBus() + " | Asientos: " + buses[i].asientos() + 
            " | " + ruta.origen() + " -> " + ruta.destino() + 
            " | Precio: S/. " + precioFinal + " | Fecha: " + fecha
        );
        }
        System.out.println("Elige un Buss: ");
        opcion = sc.nextInt();
        if (opcion < 1 || opcion > buses.length) {
            System.out.println("Error: Opcion no valida. Vuelva a intentar");
        }

        }while(opcion < 1 || opcion > buses.length);

        return buses[opcion - 1];
         

    }
}
