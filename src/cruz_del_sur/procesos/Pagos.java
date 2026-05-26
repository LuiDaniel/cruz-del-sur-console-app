package cruz_del_sur.procesos;

import java.util.Scanner;
import cruz_del_sur.modelos.Datos;
import cruz_del_sur.vistas.detalles.Colores;
import java.util.InputMismatchException;

public class Pagos {

    // OBTENER EL TOTAL
    public static double obtenerPrecio(Datos.Pasaje pasaje) {
        double subtotal = pasaje.ruta().precio() + pasaje.bus().variacionPrecio();
        double igv = subtotal * 0.18;
        return subtotal + igv;
    }

    // ELEGIR MÉTODO DE PAGO
    public static boolean tipoDePago(double montoAPagar) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion < 1 || opcion > 3) {
            System.out.println(Colores.BG_AZUL + Colores.BLANCO + Colores.NEGRITA + "\n═══════════════════════════════════════\n            MÉTODOS DE PAGO           \n═══════════════════════════════════════" + Colores.RESET);
            System.out.println(Colores.BRIGHT_VERDE + "💰 MONTO A PAGAR: S/ " + String.format("%.2f", montoAPagar) + Colores.RESET);
            System.out.println();
            System.out.println(Colores.BRIGHT_CYAN + "1️⃣  Tarjeta" + Colores.RESET);
            System.out.println(Colores.BRIGHT_MORADO + "2️⃣  Yape" + Colores.RESET);
            System.out.println(Colores.BRIGHT_AMARILLO + "3️⃣  Efectivo" + Colores.RESET);
            System.out.println();
            System.out.print(Colores.NEGRITA + "Seleccione una opción: " + Colores.RESET);

            try {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 3) {
                    System.out.println(Colores.ROJO + "❌ Opción inválida." + Colores.RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(Colores.ROJO + "❌ Debe ingresar un número." + Colores.RESET);
                sc.nextLine();
            }
        }

        switch (opcion) {
            case 1: return procesarPagoConTarjeta(montoAPagar);
            case 2: return procesarPagoConYape(montoAPagar);
            case 3: return procesarPagoEfectivo(montoAPagar);
            default:
                System.out.println(Colores.ROJO + "Método no disponible." + Colores.RESET);
                return false;
        }
    }

    // TARJETA
    public static boolean procesarPagoConTarjeta(double montoAPagar) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colores.BG_AZUL + Colores.BLANCO + Colores.NEGRITA + "\n═══════════════════════════════════════\n         PASARELA DE PAGO VISA        \n═══════════════════════════════════════" + Colores.RESET);
        System.out.println(Colores.BRIGHT_VERDE + "💳 Monto a pagar: S/ " + String.format("%.2f", montoAPagar) + Colores.RESET); //
        System.out.println(Colores.AMARILLO + "(Escriba X para cancelar)" + Colores.RESET);

        Datos.Tarjeta tarjetaCliente = null;

        while (tarjetaCliente == null) {
            try { // intento
                // NÚMERO
                System.out.print(Colores.BRIGHT_CYAN + "\n💳 Número de tarjeta: " + Colores.RESET);
                String num = sc.nextLine().trim().replace(" ", "");
                if (num.equalsIgnoreCase("X")) return false;

                // TITULAR
                System.out.print(Colores.BRIGHT_VERDE + "👤 Titular: " + Colores.RESET);
                String titular = sc.nextLine().trim();
                if (titular.equalsIgnoreCase("X")) return false;

                // VENCIMIENTO
                System.out.print(Colores.BRIGHT_AMARILLO + "📅 Vencimiento (MM/AA): " + Colores.RESET);
                String vencimiento = sc.nextLine().trim();
                if (vencimiento.equalsIgnoreCase("X")) return false;

                // CVV
                System.out.print(Colores.BRIGHT_MORADO + "🔐 CVV: " + Colores.RESET);
                String cvv = sc.nextLine().trim();
                if (cvv.equalsIgnoreCase("X")) return false;

                tarjetaCliente = new Datos.Tarjeta(num, titular, vencimiento, cvv);

            } catch (IllegalArgumentException e) {
                System.out.println(Colores.BG_ROJO + Colores.BLANCO + Colores.NEGRITA + "\n ERROR " + Colores.RESET);
                System.out.println(Colores.BRIGHT_ROJO + "❌ " + e.getMessage() + Colores.RESET);
                System.out.println(Colores.AMARILLO + "⚠ Intente nuevamente." + Colores.RESET);
            }
        }

        System.out.println();
        System.out.println(Colores.CYAN + "⏳ Validando fondos..." + Colores.RESET);
        System.out.println(Colores.BG_VERDE + Colores.BLANCO + Colores.NEGRITA + " ✔ PAGO APROBADO " + Colores.RESET);
        return true;
    }

    // YAPE
    public static boolean procesarPagoConYape(double montoAPagar) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colores.BG_MORADO + Colores.BLANCO + Colores.NEGRITA + "\n═══════════════════════════════════════\n              PAGO CON YAPE           \n═══════════════════════════════════════" + Colores.RESET);
        System.out.println(Colores.BRIGHT_VERDE + "📱 Monto a pagar: S/ " + String.format("%.2f", montoAPagar) + Colores.RESET);
        System.out.println(Colores.AMARILLO + "(Escriba X para cancelar)" + Colores.RESET);

        while (true) {
            System.out.print(Colores.BRIGHT_CYAN + "\n📞 Número de celular: " + Colores.RESET);
            String celular = sc.nextLine().trim();
            if (celular.equalsIgnoreCase("X")) return false;

            if (!celular.matches("\\d{9}")) {
                System.out.println(Colores.ROJO + "❌ El número debe tener 9 dígitos." + Colores.RESET);
                continue;
            }

            System.out.print(Colores.BRIGHT_AMARILLO + "🔢 Código de confirmación: " + Colores.RESET);
            String codigo = sc.nextLine().trim();
            if (codigo.equalsIgnoreCase("X")) return false;

            System.out.println();
            System.out.println(Colores.CYAN + "⏳ Validando Yape..." + Colores.RESET);
            System.out.println(Colores.BG_VERDE + Colores.BLANCO + Colores.NEGRITA + " ✔ PAGO APROBADO " + Colores.RESET);
            return true;
        }
    }

    // EFECTIVO
    public static boolean procesarPagoEfectivo(double montoAPagar) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colores.BG_AMARILLO + Colores.NEGRO + Colores.NEGRITA + "\n═══════════════════════════════════════\n            PAGO EN EFECTIVO          \n═══════════════════════════════════════" + Colores.RESET);
        System.out.println(Colores.BRIGHT_VERDE + "💵 Monto a pagar: S/ " + String.format("%.2f", montoAPagar) + Colores.RESET);

        try {
            System.out.print(Colores.BRIGHT_CYAN + "\n💰 Dinero entregado: " + Colores.RESET);
            double dinero = sc.nextDouble();

            if (dinero < montoAPagar) {
                System.out.println(Colores.ROJO + "❌ Dinero insuficiente." + Colores.RESET);
                return false;
            }

            double vuelto = dinero - montoAPagar;
            System.out.println();
            System.out.println(Colores.BG_VERDE + Colores.BLANCO + Colores.NEGRITA + " ✔ PAGO APROBADO " + Colores.RESET);
            System.out.println(Colores.BRIGHT_VERDE + "💸 Vuelto: S/ " + String.format("%.2f", vuelto) + Colores.RESET);
            return true;

        } catch (InputMismatchException e) {
            System.out.println(Colores.ROJO + "❌ Debe ingresar números." + Colores.RESET);
            return false;
        }
    }

    // IMPRIMIR BOLETA
    public static void imprimirBoleta(Datos.Boleta boleta) {
        System.out.println(Colores.BRIGHT_AZUL + Colores.NEGRITA + "====================================================" + Colores.RESET);
        System.out.println(Colores.NEGRITA + Colores.BRIGHT_BLANCO + "                 CRUZ DEL SUR" + Colores.RESET);
        System.out.println(Colores.BRIGHT_AMARILLO + "             El Placer de Viajar en Bus!" + Colores.RESET);
        System.out.println(Colores.BRIGHT_NEGRO + "          TRANSPORTES CRUZ DEL SUR S.A.C." + Colores.RESET);
        System.out.println(Colores.BRIGHT_NEGRO + "RUC : " + boleta.ruc() + Colores.RESET);
        System.out.println(Colores.NEGRITA + Colores.BRIGHT_BLANCO + "BOLETA DE VENTA ELECTRÓNICA" + Colores.RESET);
        System.out.println(Colores.CYAN + "----------------------------------------------------" + Colores.RESET);

        // CLIENTE
        System.out.println(Colores.NEGRITA + Colores.AMARILLO + "DATOS DEL CLIENTE" + Colores.RESET);
        System.out.println("DNI      : " + boleta.dni());
        System.out.println("NOMBRE   : " + boleta.nombre());
        if (boleta.correo() != null) { // si el correo no esta vacio imprimimos el correo
            System.out.println("CORREO   : " + boleta.correo());
        }
        System.out.println();

        // VIAJE
        System.out.println(Colores.NEGRITA + Colores.AMARILLO + "DETALLE DEL VIAJE" + Colores.RESET);
        System.out.println("SERVICIO : " + boleta.servicio());
        System.out.println("RUTA     : " + boleta.ruta());
        System.out.println("BUS      : " + boleta.bus());
        System.out.println("FECHA    : " + boleta.fecha());
        if (boleta.agencia() != null) {
            System.out.println("AGENCIA  : " + boleta.agencia());
        }
        System.out.println();
        System.out.println(Colores.CYAN + "----------------------------------------------------" + Colores.RESET);

        // MONTOS
        System.out.println(Colores.NEGRITA + Colores.AMARILLO + "RESUMEN DE PAGO" + Colores.RESET);
        System.out.printf("SUBTOTAL    : S/ %.2f%n", boleta.subtotal());
        System.out.printf("IGV         : S/ %.2f%n", boleta.igv());
        System.out.printf("DESCUENTO   : S/ %.2f%n", boleta.descuento());
        System.out.println();

        System.out.println(Colores.BG_AZUL + Colores.BLANCO + Colores.NEGRITA + " TOTAL A PAGAR : S/ " + String.format("%.2f", boleta.total()) + " " + Colores.RESET);
        System.out.println();

        if (boleta.totalString() != null) {
            System.out.println(Colores.BRIGHT_CYAN + "SON: " + boleta.totalString() + Colores.RESET);
        }
        System.out.println();
        System.out.println(Colores.CYAN + "====================================================" + Colores.RESET);
        System.out.println(Colores.BRIGHT_VERDE + "        ¡Gracias por viajar con nosotros!" + Colores.RESET);
    }
} 