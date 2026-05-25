package cruz_del_sur.procesos;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cruz_del_sur.modelos.Datos;
import cruz_del_sur.modelos.Datos.Bus;
import cruz_del_sur.modelos.Datos.Pasaje;
import cruz_del_sur.modelos.Datos.Ruta;
import cruz_del_sur.vistas.detalles.Colores;

import java.time.LocalDate;

public class Funciones {
    public static Scanner sc = new Scanner(System.in);

    // Seleccionar origen
    public static String elegirOrigen() {
        System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "-----ORIGENES-----" + Colores.RESET);

        // Creamos una lista vacia para añadir los origenes sin repeticion
        Set<String> origenes = new LinkedHashSet<>();
        for (Datos.Ruta ruta : Datos.rutas) {
            origenes.add(ruta.origen());
        }

        List<String> listaOrigenes = new ArrayList<>(origenes);

        for (int i = 0; i < listaOrigenes.size(); i++) {
            System.out.println(
                    Colores.AMARILLO + (i + 1) + ". " + Colores.VERDE + listaOrigenes.get(i) + Colores.RESET);
        }

        int opcion = 0;
        while (opcion < 1 || opcion > cruz_del_sur.modelos.rutas.length) {
            System.out.println("Seleccione origen: ");
            opcion = validarOpcion(1, listaOrigenes.size());
        }

        // devuelve el origen de la ruta seleccionada en String
        return listaOrigenes.get(opcion - 1);
    }

    // Seleccionar Destino
    public static String elegirDestino(String origen) {
        System.out.println(
                Colores.BG_NEGRO +
                        Colores.NEGRITA +
                        "-----DESTINOS-----" +
                        Colores.RESET);

        List<String> destinos = new ArrayList<>();
        for (Datos.Ruta ruta : Datos.rutas) {
            if (origen.equalsIgnoreCase(ruta.origen())) {
                destinos.add(ruta.destino());
            }
        }
        for (int i = 0; i < destinos.size(); i++) {
            System.out.println(
                    Colores.AMARILLO +
                            (i + 1) +
                            ". " +
                            Colores.VERDE +
                            destinos.get(i) +
                            Colores.RESET);
        }
        int opcion = 0;
        while (opcion < 1 || opcion > destinos.size()) {
            System.out.print("Seleccione destino: ");
            opcion = validarOpcion(1, destinos.size());
        }

        return destinos.get(opcion - 1);
    }

    // Seleccionar Fecha
    public static LocalDate elegirFecha() {
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "¿Cuándo viajas?" + Colores.RESET);
            System.out.println(Colores.AMARILLO + "1." + Colores.MORADO + " Hoy" + Colores.RESET);
            System.out.println(Colores.AMARILLO + "2." + Colores.MORADO + " Mañana" + Colores.RESET);
            System.out.println(Colores.AMARILLO + "3." + Colores.MORADO + " Elegir" + Colores.RESET);
            opcion = validarOpcion(1, 3);
        }
        if (opcion == 1) {
            return LocalDate.now(); // devuelve la fecha actual
        } else if (opcion == 2) {
            return LocalDate.now().plusDays(1); // agrega un dia a la fecha actual
        } else if (opcion == 3) {
            int dia = 0;
            LocalDate hoy = LocalDate.now(); // obtenemos la fecha actual
            while (dia < hoy.getDayOfMonth() || dia > hoy.lengthOfMonth()) {
                System.out.print("Dia: ");
                if (sc.hasNextInt()) {
                    dia = sc.nextInt();
                    if (dia < hoy.getDayOfMonth() || dia > hoy.lengthOfMonth()) {
                        System.out.println(
                                cruz_del_sur.vistas.detalles.Colores.ROJO
                                        + "El dia no está dentro del rango disponible: "
                                        + cruz_del_sur.vistas.detalles.Colores.BLANCO
                                        + hoy.getDayOfMonth()
                                        + " - "
                                        + hoy.lengthOfMonth()
                                        + cruz_del_sur.vistas.detalles.Colores.RESET);
                        // sc.next();
                    }
                } else {
                    System.out
                            .println(cruz_del_sur.vistas.detalles.Colores.ROJO + "Error. debe ingresar un numero" + cruz_del_sur.vistas.detalles.Colores.RESET);
                    sc.next();
                }

            }
            return LocalDate.of(hoy.getYear(), hoy.getMonthValue(), dia); // devuelve la fecha seleccionada
        } else {
            System.out.println("Error");
        }
        return null;
    }

    // Guardar ruta Seleccionada, Tipo de dato: Ruta
    public static Datos.Ruta devolverRutaSeleccionada(String origen, String destino) {
        // Iteramos todo el array de rutas hasta encontra una ruta que coincida con el
        // origen y destino seleccionado
        for (int i = 0; i < cruz_del_sur.modelos.rutas.length; i++) {
            if (origen.equalsIgnoreCase(Datos.rutas[i].origen())
                    && destino.equalsIgnoreCase(Datos.rutas[i].destino())) {
                return Datos.rutas[i];
            }
        }
        return null;
    }

    // Pasaje seleccionado, Devuelve un dato de tipo Pasaje
    public static Datos.Pasaje crearPasaje(Datos.Ruta ruta, Datos.Bus bus, LocalDate fecha) {
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
        int opcion = 0;
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
                                Colores.BLANCO + " | " + Colores.AMARILLO + "Fecha: " + Colores.BRIGHT_CYAN + fecha
                                + Colores.RESET);
            }
            System.out.print("Elige un Buss: ");
            opcion = validarOpcion(1, buses.length);
            if (opcion < 1 || opcion > buses.length) {
                System.out.println("Error: Opcion no valida. Vuelva a intentar");
            }

        } while (opcion < 1 || opcion > buses.length);

        return buses[opcion - 1];
    }

    //Validar opcion
    public static int validarOpcion(int min, int max) {
        int opcion = 0;
        while (opcion < min || opcion > max) {
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < min || opcion > max) {
                    System.out.println(
                            Colores.ROJO +
                            "Opción inválida."
                            + Colores.RESET);
                }
            } else {
                System.out.println(
                        Colores.ROJO +
                        "Debe ingresar un número."
                        + Colores.RESET);
                sc.next();
            }
        }

        return opcion;
    }
}
