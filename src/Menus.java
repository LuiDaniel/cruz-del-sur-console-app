public class Menus {
    public static Datos.Ruta busquedaDePasajes(){
        String origen = Funciones.elegirOrigen();
        String destino = Funciones.elegirDestino(origen);
        
        Datos.Ruta rutaSeleccionada = Funciones.devolverRutaSeleccionada(origen, destino);
        return rutaSeleccionada;
    }
}
