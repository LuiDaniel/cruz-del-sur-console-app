import java.util.Scanner;

public class TerminosCondiciones {
    Scanner sc = new Scanner(System.in);

    public static int mostrarTerminos(){
        //while(opcion < 1 || opcion > 11){
        System.out.println("1. T&C – Programa Viajemos (Vigente hasta el 11.08.25)");
        System.out.println("2. T&C - Código de descuento Banco Falabella - 15%");
        System.out.println("Elige el termino que quieras leer: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    public void mostrarTerminoSeleccionado(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("T&C – Programa Viajemos (Vigente hasta el 11.08.25)");
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
            
            default:
                System.out.println("gggg");
}
