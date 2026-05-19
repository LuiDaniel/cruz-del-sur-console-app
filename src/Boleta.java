import tu.paquete.NumeroALetras;
import java.time.LocalDate;
public class Boleta {
    public static Datos.Boleta generarBoleta(Datos.Cliente cliente, Datos.Pasaje pasaje){

         System.out.println("Cruz del Sur");

        // Ruta Completa
        String ruta = pasaje.ruta().origen() + " --> " + pasaje.ruta().destino();

        // Fecha Actual
        LocalDate fecha = LocalDate.now();

        // Subtotal 
        double subtotal = pasaje.ruta().precio() + pasaje.bus().variacionPrecio();

        // IGV 18%
        double igv = subtotal * 0.18;

        // Total
        double total = subtotal + igv;
        //Separar 
        int soles = (int) total;
        int centimos = (int) Math.round((total - soles)*100);
        // Convertir a letras
        String totalEnLetras = NumeroALetras.convertir(soles) + " con " + NumeroALetras.convertir(centimos) + " centimos ";

        // Ccodigo Boleta
        String CodigoBoleto = "1234";

        // Servicio
        String servicio = pasaje.bus().tipoBus();

        // Agencia
        String agencia = pasaje.ruta().origen();


        Datos.Boleta boleta = new Datos.Boleta(pasaje.ruta().origen(), "1234", cliente.dni(), cliente.nombres(), cliente.correo(),"jhfasdugh", ruta, pasaje.bus().tipoBus(), fecha, subtotal, igv, 0, total, null, pasaje.ruta().origen())
        return boleta;
    }
}
