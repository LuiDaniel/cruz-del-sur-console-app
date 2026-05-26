package cruz_del_sur.vistas;

import java.util.Scanner;
import cruz_del_sur.modelos.Datos;
import cruz_del_sur.vistas.detalles.Colores;
import java.util.InputMismatchException;

public class FormularioCliente {

    public static Datos.Cliente pedirDatos() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                // TÍTULO
                System.out.println("\n" + Colores.BG_AZUL + Colores.BLANCO + Colores.NEGRITA + "═══════════════════════════════════════\n         DATOS DEL PASAJERO         \n═══════════════════════════════════════" + Colores.RESET);

                // DNI
                System.out.print(Colores.BRIGHT_CYAN + Colores.NEGRITA + "🪪 Ingrese su DNI (8 dígitos): " + Colores.RESET);
                String dni = sc.nextLine().trim();

                // NOMBRE
                System.out.print(Colores.BRIGHT_VERDE + Colores.NEGRITA + "👤 Ingrese su nombre: " + Colores.RESET);
                String nombre = sc.nextLine().trim();

                // APELLIDOS
                System.out.print(Colores.BRIGHT_VERDE + Colores.NEGRITA + "👥 Ingrese sus dos apellidos: " + Colores.RESET);
                String apellido = sc.nextLine().trim();

                // CORREO
                System.out.print(Colores.BRIGHT_AMARILLO + Colores.NEGRITA + "📧 Ingrese su correo: " + Colores.RESET);
                String correo = sc.nextLine().trim();

                // FECHA
                System.out.println("\n" + Colores.MORADO + Colores.NEGRITA + "📅 FECHA DE NACIMIENTO" + Colores.RESET);

                System.out.print(Colores.CYAN + "Día: " + Colores.RESET);
                int dia = sc.nextInt();

                System.out.print(Colores.CYAN + "Mes: " + Colores.RESET);
                int mes = sc.nextInt();

                System.out.print(Colores.CYAN + "Año: " + Colores.RESET);
                int anio = sc.nextInt();

                sc.nextLine(); // limpiar buffer

                // GÉNERO
                System.out.print(Colores.BRIGHT_MORADO + Colores.NEGRITA + "⚧ Ingrese su género (M/F): " + Colores.RESET);
                String genero = sc.nextLine().trim().toUpperCase();

                // CREAR CLIENTE
                Datos.Cliente cliente = new Datos.Cliente(dni, nombre, apellido, correo, dia, mes, anio, genero);

                // ÉXITO
                System.out.println("\n" + Colores.BG_VERDE + Colores.BLANCO + Colores.NEGRITA + " ✔ Datos registrados correctamente " + Colores.RESET + "\n");

                return cliente;

            } catch (InputMismatchException e) {

                System.out.println("\n" + Colores.BG_ROJO + Colores.BLANCO + Colores.NEGRITA + " ERROR " + Colores.RESET);
                System.out.println(Colores.ROJO + "❌ Has ingresado letras en la fecha.\nSolo se permiten números." + Colores.RESET);
                System.out.println(Colores.AMARILLO + "⚠ Vuelve a ingresar los datos.\n" + Colores.RESET);

                sc.nextLine(); // limpiar buffer

            } catch (IllegalArgumentException e) {

                System.out.println("\n" + Colores.BG_ROJO + Colores.BLANCO + Colores.NEGRITA + " ERROR EN LOS DATOS " + Colores.RESET);
                System.out.println(Colores.BRIGHT_ROJO + "❌ " + e.getMessage() + Colores.RESET);
                System.out.println(Colores.AMARILLO + "Intente nuevamente.\n" + Colores.RESET);
            }
        }
    }
}