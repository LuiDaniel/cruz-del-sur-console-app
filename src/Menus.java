import java.time.LocalDate;

public class Menus {
    public static Datos.Pasaje busquedaDePasajes(){
        String origen = Funciones.elegirOrigen();
        String destino = Funciones.elegirDestino(origen);
        Datos.Ruta rutaSeleccionada = Funciones.devolverRutaSeleccionada(origen, destino);
        LocalDate fecha = Funciones.elegirFecha();
        Datos.Bus bus = Funciones.mostrarBuses(Datos.buses, rutaSeleccionada, fecha);
        Datos.Pasaje pasaje = Funciones.pasaje(rutaSeleccionada, bus, fecha);
        return pasaje;
    }
    public static void prueba(Datos.Pasaje pasaje){
        double precio = Pagos.obtenerPrecio(pasaje);
        boolean exito = Pagos.procesarPagoConTarjeta(precio);
    }
}
