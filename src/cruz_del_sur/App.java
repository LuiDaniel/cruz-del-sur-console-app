package cruz_del_sur;
import java.time.LocalDate;
import java.util.Scanner;

import cruz_del_sur.modelos.Datos;
import cruz_del_sur.procesos.Boleta;
import cruz_del_sur.procesos.Funciones;
import cruz_del_sur.procesos.Pagos;
import cruz_del_sur.vistas.FormularioCliente;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void inicio() {
        System.out.println("--- BIENVENIDOS A CRUZ DEL SUR ---");
        System.out.println("'¿Que desea hacer hoy?");
        System.out.println("1. Comprar Pasaje.");
        System.out.println("2. Contactanos");
        System.out.println("3. Terminos y condiciones");
        System.out.println("4. Ver buses");
        System.out.println("5. Ver ciudadedes dsponibles");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                App.ComprarPasaje();
                App.volverAlInicio();
                break;
            case 2:
                cruz_del_sur.vistas.detalles.Contactos.mostrarDatosEmpresa(cruz_del_sur.vistas.detalles.Contactos.datosEmpresa);
                App.volverAlInicio();
                break;
            case 3:
                int opcionTermino = cruz_del_sur.vistas.detalles.TerminosCondiciones.mostrarTerminos();
                cruz_del_sur.vistas.detalles.TerminosCondiciones.mostrarTerminoSeleccionado(opcionTermino);
                App.volverAlInicio();
            case 4:
                Funciones.verBuses();
                App.volverAlInicio();
            default:
                break;
        }

    }

    public static void ComprarPasaje() {
        Datos.Pasaje pasaje = App.busquedaDePasajes();
        Datos.Boleta boleta = App.generarBoleta(pasaje);
        Pagos.imprimirBoleta(boleta);
    }

    public static Datos.Pasaje busquedaDePasajes() {
        String origen = Funciones.elegirOrigen();
        String destino = Funciones.elegirDestino(origen);
        Datos.Ruta rutaSeleccionada = Funciones.devolverRutaSeleccionada(origen, destino);
        LocalDate fecha = Funciones.elegirFecha();
        Datos.Bus bus = Funciones.mostrarBuses(Datos.buses, rutaSeleccionada, fecha);
        Datos.Pasaje pasaje = Funciones.crearPasaje(rutaSeleccionada, bus, fecha);
        return pasaje;
    }

    public static Datos.Boleta generarBoleta(Datos.Pasaje pasaje) {
        Datos.Cliente cliente = FormularioCliente.pedirDatos();
        double precio = Pagos.obtenerPrecio(pasaje);
        boolean exito = Pagos.tipoDePago(precio);
        if (exito) {
            return Boleta.generarBoleta(cliente, pasaje);
        } else {
            return null;
        }
    }

    public static void volverAlInicio() {
        sc.nextLine();
        System.out.println("¿Desea volver? s/n");
        String volver = sc.nextLine();
        if (volver.equalsIgnoreCase("s")) {
            App.inicio();
        } else {
            System.exit(0);
        }
    }
}
