import java.util.Scanner;

public class FormularioCliente {

    public static Datos.Cliente pedirDatos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quien viaja?");

        System.out.println("dni: ");
        String dni = sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su  fecha de nacimiento. ");
        System.out.println("dia: ");

        Datos.Cliente cliente = new Datos.Cliente(dni, nombre, null, null, 0, 0, 0, null);

        return cliente;
    }
}
