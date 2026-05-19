import java.util.Scanner;

public class FormularioCliente {

    public static Datos.Cliente pedirDatos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quien viaja?");

        System.out.println("Ingrese su DNI: ");
        String dni = sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su correo: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese su  fecha de nacimiento: ");
        System.out.println("Dia: ");
        int  dia = sc.nextInt();
        System.out.println("Mes: ");
        int mes = sc.nextInt();
        System.out.println("Año: ");
        int anio = sc.nextInt();

        sc.nextLine();

        System.out.println("Ingrese su genero: M/F");
        String genero = sc.nextLine();

        Datos.Cliente cliente = new Datos.Cliente(dni, nombre, apellido,correo, 0, 0, 0, genero);

        return cliente;
    }
}
