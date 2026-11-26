package Universidad.ProgramacionConcurrente.hilos;

public class UsoHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciado.");
        //HiloContador hc = new HiloContador("#1");
        //Thread nuevoHilo = new Thread(hc);
        HiloContador nuevoHilo = new HiloContador();
        nuevoHilo.setName("#1");
        HiloContador nuevoHilo2 = new HiloContador();
        nuevoHilo2.setName("#2");
        HiloContador nuevoHilo3 = new HiloContador();
        nuevoHilo3.setName("#3");
        nuevoHilo.start();
        nuevoHilo2.start();
        nuevoHilo3.start();

        for(int i = 0; i < 50; i++){
            System.out.println(" .");
        }

        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println("Hilo principal interrumpido");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
