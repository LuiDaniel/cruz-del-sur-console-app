
public class Main {
    public static void main(String[] args) {
        Datos.Pasaje pasaje = App.busquedaDePasajes();
        Datos.Boleta boleta = App.generarBoleta(pasaje);
        System.out.println(boleta);
        //detalles.Contactos.DatosEmpresa datos =  detalles.Contactos.datosEmpresa; 
        //detalles.Contactos.mostrarDatos(datos);
    }
}
