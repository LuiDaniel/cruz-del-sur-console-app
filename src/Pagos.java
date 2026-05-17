public class Pagos {
    
    public void pagos(Datos.Pasaje pasaje){
        System.out.println(pasaje.ruta().origen());
        System.out.println(pasaje.bus().asientos());
        double precio=pasaje.ruta().precio();

    }
}
