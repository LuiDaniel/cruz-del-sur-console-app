import java.util.Scanner;
import detalles.Colores;
import java.time.LocalDate;

public class Funciones {
    public static Scanner sc = new Scanner(System.in);

    // Seleccionar origen
    public static String elegirOrigen() {
        System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "-----ORIGENES-----" + Colores.RESET);
        // Iteramos el arreglo de rutas
        for (int i = 0; i < Datos.rutas.length; i++) {
            System.out.println(
                    Colores.AMARILLO + (i + 1) + ". " + Colores.VERDE + Datos.rutas[i].origen() + Colores.RESET);
        }
        int opcion = 0;
        while (opcion < 1 || opcion > Datos.rutas.length) {
            System.out.println("Seleccione origen: ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > Datos.rutas.length) {
            System.out.println(Colores.ROJO + "Opción inválida. Intente de nuevo." + Colores.RESET);
        }
        }
        
        // devuelve el origen de la ruta seleccionada en String
        return Datos.rutas[opcion - 1].origen();
    }

    // Seleccionar Destino
    public static String elegirDestino(String origen) {
        System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "-----DESTINOS-----" + Colores.RESET);
        // Iteramos el arreglo de rutas
        for (int i = 0; i < Datos.rutas.length; i++) {
            // Validamos el origen ingresado para mostrar solo sus destinos disponibles
            if (origen.equalsIgnoreCase(Datos.rutas[i].origen())) {
                System.out.println(
                        Colores.AMARILLO + (i + 1) + ". " + Colores.VERDE + Datos.rutas[i].destino() + Colores.RESET);
            }
        }

        System.out.println("Seleccione destino: ");
        int opcion = sc.nextInt();
        // retornamos el destino de la ruta seleccionada en String
        return Datos.rutas[opcion - 1].destino();
    }

    // Seleccionar Fecha
    public static LocalDate elegirFecha() {
        System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "¿Cuándo viajas?" + Colores.RESET);
        System.out.println(Colores.AMARILLO + "1." + Colores.MORADO + " Hoy" + Colores.RESET);
        System.out.println(Colores.AMARILLO + "2." + Colores.MORADO + " Mañana" + Colores.RESET);
        System.out.println(Colores.AMARILLO + "3." + Colores.MORADO + " Elegir" + Colores.RESET);
        int opcion = sc.nextInt();
        if (opcion == 1) {
            return LocalDate.now(); // devuelve la fecha actual
        } else if (opcion == 2) {
            return LocalDate.now().plusDays(1); // agrega un dia a la fecha actual
        } else if (opcion == 3) {
            System.out.println("Dia: ");
            int dia = sc.nextInt();
            LocalDate hoy = LocalDate.now(); // obtenemos la fecha actual
            return LocalDate.of(2026, hoy.getMonthValue(), dia); // devuelve la fecha seleccionada
        } else {
            System.out.println("Error");
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
        /*
         * Retorna un dato de tipo Pasaje:
         * Ruta:
         * origen,
         * destino,
         * precio
         * Bus:
         * tipoBus,
         * Asiento,
         * VariacionPrecio
         * fecha,
         * EJEMPLO: Pasaje[bus=Bus[tipoBus=Suite, asientos=160, variacionPrecio=47.0],
         * ruta=Ruta[origen=Puno, destino=Lima, precio=130.0], fecha=2026-05-18]
         */
    }

    // Mostrar y seleccionar buses disponibles
    public static Datos.Bus mostrarBuses(Datos.Bus[] buses, Datos.Ruta ruta, LocalDate fecha) {
        int opcion;
        do {
            System.out.println(
                    Colores.BG_NEGRO + Colores.NEGRITA + "------Viajes recomendados para ti-----" + Colores.RESET);
            for (int i = 0; i < Datos.buses.length; i++) {
                double precioFinal = ruta.precio() + buses[i].variacionPrecio();
                System.out.println(
                        Colores.AMARILLO + (i + 1) + ". " +
                        Colores.MORADO + buses[i].tipoBus() +
                        Colores.BLANCO + " | " + Colores.AMARILLO + "Asientos: " + Colores.RESET
                        + buses[i].asientos() +
                        Colores.BLANCO + " | " + Colores.CYAN + ruta.origen() + Colores.AMARILLO + " -> "
                        + Colores.CYAN + ruta.destino() +
                        Colores.BLANCO + " | " + Colores.AMARILLO + "Precio: S/. " + Colores.VERDE + precioFinal
                        +
                        Colores.BLANCO + " | " + Colores.AMARILLO + "Fecha: " + Colores.BRIGHT_CYAN + fecha + Colores.RESET);
            }
            System.out.print("Elige un Buss: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > buses.length) {
                System.out.println("Error: Opcion no valida. Vuelva a intentar");
            }

        } while (opcion < 1 || opcion > buses.length);

        return buses[opcion - 1];
    }
}
