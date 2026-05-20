package detalles;
import java.util.Scanner;

public class TerminosCondiciones {

    public static int mostrarTerminos(){
        Scanner sc = new Scanner(System.in);
        //while(opcion < 1 || opcion > 11){
        System.out.println("1. T&C - Programa Viajemos (Vigente hasta el 11.08.25)");
        System.out.println("2. T&C - Código de descuento Banco Falabella - 15%");
        System.out.println("3. T&C - BBVA - 15%");
        System.out.println("4. T&C - BUSHOTEL");
        System.out.println("5. T&C - RETORNO20");
        System.out.println("6. T&C - Descuento Migración del programa Viajeros a Pasajero Frecuente");
        System.out.println("7. T&C Promoción: Arequipa desde S/99");
        System.out.println("Elige el termino que quieras leer: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    public void mostrarTerminoSeleccionado(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("T&C - Programa Viajemos (Vigente hasta el 11.08.25)");
                System.out.println("1. El programa Viajemos es una iniciativa de Cruz del Sur para premiar la fidelidad de nuestros clientes y ofrecerles beneficios exclusivos en sus viajes.");
                System.out.println("2. Para participar en el programa, los clientes deben registrarse en nuestro sitio web o en nuestras oficinas comerciales, proporcionando sus datos personales y aceptando los términos y condiciones del programa.");
                System.out.println("3. Los clientes acumulan puntos por cada viaje realizado con Cruz del Sur, los cuales pueden canjear por descuentos, promociones especiales o servicios adicionales en futuros viajes.");
                System.out.println("4. Los puntos acumulados tienen una vigencia de 24 meses a partir de la fecha de su acumulación, después de lo cual expirarán y no podrán ser canjeados.");
                System.out.println("5. Cruz del Sur se reserva el derecho de modificar o cancelar el programa Viajemos en cualquier momento, sin previo aviso, y sin que ello genere derecho a compensación alguna para los clientes.");
                break;
            case 2:
                System.out.println("T&C - Código de descuento Banco Falabella - 15%");
                System.out.println("1. El código de descuento del Banco Falabella ofrece un 15% de descuento en la compra de pasajes con Cruz del Sur, aplicable únicamente a través de nuestro sitio web oficial.");
                System.out.println("2. Para utilizar el código de descuento, los clientes deben ingresar el código proporcionado por el Banco Falabella durante el proceso de compra en línea, antes de finalizar la transacción.");
                System.out.println("3. El código de descuento es válido solo para titulares de tarjetas del Banco Falabella y no es acumulable con otras promociones o descuentos ofrecidos por Cruz del Sur.");
                System.out.println("4. El código de descuento tiene una vigencia limitada, que será especificada por el Banco Falabella al momento de su distribución, y no podrá ser utilizado después de su fecha de expiración.");
                System.out.println("5. Cruz del Sur se reserva el derecho de cancelar o modificar esta promoción en cualquier momento, sin previo aviso, y sin que ello genere derecho a compensación alguna para los clientes.");
                break;
            case 3:
                System.out.println("T&C - BBVA - 15%");
                System.out.println("1. El beneficio consiste en 15% de descuento en pasajes nacionales, ida/vuelta.");
                System.out.println("2. Válido para viajar en el servicio Ica Line y el 2do piso de los buses: Suite, y Evolution.");
                System.out.println("3. Válido para compras por la web: https://www.cruzdelsur.com.pe/ ingresando el cupón de descuento.");
                System.out.println("4. No acumulable con otras promociones o descuentos.");
                System.out.println("5. Descuento aplica para comprar un máximo de 05 pasajes por tarjeta.");
                break;
            case 4:
                System.out.println("T&C - BUSHOTEL");    
                System.out.println("1. Promoción del 15% de descuento en viajes nacionales, ida y/o vuelta.");
                System.out.println("2. Válido para compras en rutas nacionales desde el 30.05.2026 hasta 13.12.2026.");
                System.out.println("3. No acumulable con otras promociones y/o descuentos.");
                System.out.println("4. Válido para viajar en el servicio Ica Line y el 2do piso de los buses:  Suite y Evolution.");
                System.out.println("5. Válido para compras por la web: www.cruzdelsur.com.pe  ingresando el cupón de descuento.");
                break;
            case 5:
                System.out.println("T&C - RETORNO20"); 
                System.out.println("1. Descuento del 20% en pasajes de retorno a nivel nacional en rutas disponibles.");
                System.out.println("2. Promoción válida para comprar solo por la web: https://www.cruzdelsur.com.pe/ ingresando el código enviado por SMS.");
                System.out.println("3. Válido para comprar del 20 de mayo al 31 de octubre del 2026."); 
                System.out.println("4. Válido para viajar en el servicio Ica Line y el 2do piso de los buses: Suite y Evolution.");
                System.out.println("5. No acumulable con otras promociones y/o descuentos.");
                break;
            case 6:
                System.out.println("T&C - Descuento Migración del programa Viajeros a Pasajero Frecuente");
                System.out.println("1. Vigencia del ofrecimiento: 180 días, contabilizados desde recibida esta comunicación.");
                System.out.println("2. Válido para una compra de máximo 5 boletos.");
                System.out.println("3. No acumulable con otras promociones y/o descuentos.");
                System.out.println("4. Para hacer uso de este descuento deberá enviar un correo a servicioalcliente@cruzdelsur.com.pe 7 días antes de requerir el descuento.");
                System.out.println("5. Válido en asientos del servicio: Cruzero Suite Cruzero Evolution e Ica Express.");
                break;
            case 7:
                System.out.println("T&C Promoción: Arequipa desde S/99");    
                System.out.println("1. Promoción válida para viajes de ida del 1 al 30 de junio del 2026.");
                System.out.println("2. Stock sujeto a disponibilidad de asientos.");
                System.out.println("3. Tarifa promocional aplica únicamente para el servicio Evolution.");
                System.out.println("4. Promoción válida para comprar solo por la web.");
                System.out.println("5. No acumulable con otras promociones y/o descuentos.");
                break;
                default:
                System.out.println("Rafinha ");
        }
    }
}
