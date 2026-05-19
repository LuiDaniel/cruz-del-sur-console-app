package detalles;

public class Contactos {
    // CREDENCIALES
    public record DatosEmpresa(
            String nombre,
            String derechosReservados,
            String direccion,
            String correo,
            String numero,
            String fb,
            String youtube,
            String ig,
            String twiter) {
    }

    static DatosEmpresa datosEmpresa = (
        new DatosEmpresa(
            "Cruz del sur",
            "2024 CRUZ DEL SUR | TODOS LOS DERECHOS RESERVADOS",
            "Av. Javier Prado 1109, La Victoria - Lima, Perú",
            "cruzdelsur@gmail.com", 
            "+51 987 876 567", 
            "", 
            "", 
            "", 
            ""));

    public static void mostrarDatos(DatosEmpresa datos) {
        System.out.println(Colores.AMARILLO + datos.nombre() + Colores.RESET);
        System.out.println(""); 

    }

}
