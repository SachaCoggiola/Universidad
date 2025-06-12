package Universidad.RPA.UnidadCinco;

import java.util.Scanner;

public class enunciadoOcho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int descuentoArte = 25;
        int descuentoPapel = 10;
        String respuesta = "si";
        double montoFinal = 0;
        int cantProducArte = 0;
        int cantProducPapel = 0;
        int cantProducUtil = 0;
        int precioMayor = 0;
        int precioProducto;
        String tipoProducto;
        do{
            System.out.println("Ingrese el precio del producto que desea comprar: ");
            precioProducto = sc.nextInt();
            System.out.println("Ingrese Papel si lleva un producto de papelería, Arte si lleva un producto del rubro artistíco o Otro si lleva algún otro útil escolar: ");
            tipoProducto = sc.next();
            if(tipoProducto.equals("Arte")){
                cantProducArte++;
                precioProducto -= (precioProducto*descuentoArte/100);
            }else if(tipoProducto.equals("Papel")){
                cantProducPapel++;
                precioProducto -= (precioProducto*descuentoPapel/100);
            }else {
                cantProducUtil++;
            }
            if(precioMayor < precioProducto){
                precioMayor = precioProducto;
            }
            montoFinal += precioProducto;
            System.out.println("El precio del producto es: " + precioProducto);
            System.out.println("¿Desea llevar más productos?. Responda con si o con no.");
        }while(sc.next().equals(respuesta));
        System.out.println("El monto final de su compra es de: " + montoFinal);
        System.out.println("El producto más caro de su compra tiene un valor de: " + precioMayor);
        System.out.println("Usted se lleva un total de "+cantProducArte+" productos del rubro Artistico.");
        System.out.println("Usted se lleva un total de "+cantProducPapel+" productos de papelería.");
        System.out.println("Usted se lleva un total de "+cantProducUtil+" productos de utileria.");
    }
}
