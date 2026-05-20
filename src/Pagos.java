import java.util.Scanner;

public class Pagos {
    // OBTENER EL SUBTOTAL

    // obtener el precio en double mediante el Pasaje Para validar pagos
    public static double obtenerPrecio(Datos.Pasaje pasaje) {
        double subtotal = pasaje.ruta().precio() + pasaje.bus().variacionPrecio(); //100
        double igv = subtotal * 0.18; // 18
        return subtotal + igv; //118
    }

    // ELEGIR METODO DE PAGO
    public static boolean tipoDePago(double montoAPagar) { //118
        Scanner sc = new Scanner(System.in);
        int opcion  = -1;

        while (opcion < 1 || opcion > 3) {
            System.out.println("SELECCIONE EL MEDIO DE PAGO: ");
            System.out.println("1. Tarjeta.");
            System.out.println("2. Yape.");
            System.out.println("3. Efectivo.");
            opcion = sc.nextInt();
        }

        switch (opcion) {
            case 1:
                return procesarPagoConTarjeta(montoAPagar);
            case 2:
                return procesarPagoConYape(montoAPagar);
            case 3:
                return procesarPagoEfectivo(montoAPagar);
            default:
                System.out.println("Método no disponible.");
                return false;
        }
    }

    // TARJETA
    public static boolean procesarPagoConTarjeta(double montoAPagar) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- PASARELA DE PAGO CRUZ DEL SUR ---");
        System.out.printf("Monto a abonar: S/. %.2f\n", montoAPagar);
        System.out.println("(Puedes escribir 'X' en cualquier campo para cancelar y volver)");

        Datos.Tarjeta tarjetaCliente = null;

        while (tarjetaCliente == null) {
            try {
                // 1. Número de tarjeta
                System.out.println("Ingrese número de tarjeta (16 dígitos): ");
                String num = sc.nextLine().trim().replace(" ", "");
                if (num.equalsIgnoreCase("X"))
                    return false; // Salida inmediata

                // 2. Titular
                System.out.println("Ingrese nombre completo del titular: ");
                String titular = sc.nextLine().trim();
                if (titular.equalsIgnoreCase("X"))
                    return false;

                // 3. Vencimiento
                System.out.println("Ingrese fecha de vencimiento (MM/AA): ");
                String vencimiento = sc.nextLine().trim();
                if (vencimiento.equalsIgnoreCase("X"))
                    return false;

                // 4. CVV
                System.out.println("Ingrese CVV (3 dígitos): ");
                String cvv = sc.nextLine().trim();
                if (cvv.equalsIgnoreCase("X"))
                    return false;

                // Intento de validación y creación del record
                tarjetaCliente = new Datos.Tarjeta(num, titular, vencimiento, cvv);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, intente de nuevo o presione 'X' para salir.");
            }
        }

        // Si el bucle termina con éxito, el pago se procesa
        System.out.println("\nValidando fondos...");
        System.out.println("💳 ¡Pago aprobado con éxito!");
        return true;
    }

    // YAPE
    public static boolean procesarPagoConYape(double montoAPagar) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- PASARELA YAPE CRUZ DEL SUR ---");
        System.out.printf("Monto a abonar: S/. %.2f\n", montoAPagar);
        System.out.println("(Escribe 'X' para cancelar)");

        while (true) {

            System.out.println("\nIngrese número de celular registrado en Yape: ");
            String celular = sc.nextLine().trim();
            if (celular.equalsIgnoreCase("X")) {
                return false;
            }

            if (!celular.matches("\\d{9}")) {
                System.out.println("Error: el numero debe tener 9 digitos.");
                return false;
            }

            System.out.println("Ingrese codigo de confirmacion Yape: ");
            String codigo = sc.nextLine().trim();
            if (codigo.equalsIgnoreCase("X")) {
                return false;
            }

            System.out.println("\nValidando Yape...");
            System.out.println(" Pago aprobado con éxito!");

            return true;
        }
    }

    // PAGO EN EFECTIVO
    public static boolean procesarPagoEfectivo(double montoAPagar) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- PAGO EN EFECTIVO ---");
        System.out.println("Monto a pagar: S/." + montoAPagar);

        System.out.println("Ingrese dinero entregado: ");
        double dinero = sc.nextDouble();

        if (dinero < montoAPagar) {
            System.out.println("Dinero insuficiente.");
            return false;
        }

        double vuelto = dinero - montoAPagar;

        System.out.println("Pago aprobado.");
        System.out.printf("Vuelto: S/. %.2f\n", vuelto);

        return true;
    }
}
