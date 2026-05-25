package cruz_del_sur.vistas.detalles;

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
    
    // Eliminamos los paréntesis externos () y ordenamos los datos según el record
    public static DatosEmpresa datosEmpresa = new DatosEmpresa(
            "Cruz del sur",
            "2024 CRUZ DEL SUR | TODOS LOS DERECHOS RESERVADOS",
            "Av. Javier Prado 1109, La Victoria - Lima, Perú",
            "cruzdelsur@gmail.com",
            "+51 987 876 567",
            "Facebook: CRUZ DEL SUR", // fb
            "Youtube: @CRUZ DEL SUR", // youtube
            "ig: @cruzdelsur", // ig
            "Twitter:@CRUZ DEL SUR" // twiter
    );

    public static void mostrarDatosEmpresa(DatosEmpresa datos) { //datosEmpresa
        System.out.println(Colores.AMARILLO + datos.nombre() + Colores.RESET);
        System.out.println("===============================");
        System.out.println("CONTACTOS EMPRESA");
        System.out.println("================================");

        System.out.println("Empresa: " + datos.nombre());
        System.out.println("Derechos Reservados: " + datos.derechosReservados());
        System.out.println("Dirección: " + datos.direccion());
        System.out.println("Correo: " + datos.correo());
        System.out.println("Número: " + datos.numero());
        System.out.println("Facebook: " + datos.fb());
        System.out.println("Youtube: " + datos.youtube());
        System.out.println("Instagram: " + datos.ig());
        System.out.println("Twitter: " + datos.twiter());

        System.out.println("===============================");

    }
}
