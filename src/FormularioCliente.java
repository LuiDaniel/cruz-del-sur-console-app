import java.util.Scanner;
import java.util.InputMismatchException;
import detalles.Colores;

public class FormularioCliente {

    public static Datos.Cliente pedirDatos() {
        Scanner sc = new Scanner(System.in);
        
        while (true) { 
            try {
                System.out.println(Colores.BG_NEGRO + Colores.NEGRITA + "¿Quién viaja?" + Colores.RESET);

                System.out.println("Ingrese su DNI (8 dígitos): ");
                String dni = sc.nextLine().trim();
                
                System.out.println("Ingrese su nombre: ");
                String nombre = sc.nextLine().trim();
                
                System.out.println("Ingrese sus dos apellidos: ");
                String apellido = sc.nextLine().trim();
                
                System.out.println("Ingrese su correo: ");
                String correo = sc.nextLine().trim();
                
                System.out.println("Ingrese su fecha de nacimiento: ");
                System.out.print("Día: ");
                int dia = sc.nextInt(); 
                System.out.print("Mes: ");
                int mes = sc.nextInt();
                System.out.print("Año: ");
                int anio = sc.nextInt();

                sc.nextLine(); // Limpiamos el buffer del entero 'anio'

                System.out.println("Ingrese su género (M/F): ");
                String genero = sc.nextLine().trim().toUpperCase();

                Datos.Cliente cliente = new Datos.Cliente(dni, nombre, apellido, correo, dia, mes, anio, genero);
                
                return cliente; // Si todo está bien, salimos del bucle con el cliente listo

            } catch (InputMismatchException e) {
                // Captura el error si el usuario digita letras en la fecha
                System.out.println("\n" + Colores.ROJO + "Error: ¡Has ingresado letras en la fecha de nacimiento! Solo se permiten números." + Colores.RESET);
                System.out.println(Colores.AMARILLO + "Por favor, vuelve a ingresar los datos desde el principio.\n" + Colores.RESET);
                sc.nextLine(); // CRUCIAL: Limpia las letras que causaron el error para evitar un bucle infinito
            } catch (IllegalArgumentException e) {
                // Captura los errores de validación del Record (DNI incompleto, correo feo, etc.)
                System.out.println("\n" + Colores.ROJO + "Error en los datos: " + e.getMessage() + Colores.RESET);
                System.out.println(Colores.AMARILLO + "Por favor, intente de nuevo.\n" + Colores.RESET);
            }
        }
    }
}