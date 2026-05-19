
public class Main {
    public static void main(String[] args) {
        Datos.Pasaje pasaje = Menus.busquedaDePasajes();
        Datos.Boleta boleta = Menus.generarBoleta(pasaje);
        System.out.println(boleta);
    }
    
    
}
