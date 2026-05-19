import java.time.LocalDate;
public class Boleta {
    public static Datos.Boleta generarBoleta(Datos.Cliente cliente, Datos.Pasaje pasaje){
        String ruta = pasaje.ruta().origen() + " --> " + pasaje.ruta().destino();
        LocalDate fecha = LocalDate.now();
        double subtotal = pasaje.bus().variacionPrecio() + pasaje.ruta().precio();
        double igv = subtotal * 0.18;
        double total = subtotal + igv; 

        //cientodiesiocho



        Datos.Boleta boleta = new Datos.Boleta(pasaje.ruta().origen(), "1234", cliente.dni(), cliente.nombres(), cliente.correo(),"jhfasdugh", ruta, pasaje.bus().tipoBus(), fecha, subtotal, igv, 0, total, null, pasaje.ruta().origen())
        return boleta;
    }
}
