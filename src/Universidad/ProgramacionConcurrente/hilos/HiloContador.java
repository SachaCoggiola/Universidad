package Universidad.ProgramacionConcurrente.hilos;

public class HiloContador extends Thread {
    public void run(){
        System.out.println("Comenzando "+getName());
        try{
            for(int i=0; i<10; i++){
                Thread.sleep(400);
                System.out.println("En "+getName()+", el recurso "+i);
            }
        }catch(InterruptedException e){
            System.out.println(getName()+" Interrumpido");
        }
        System.out.println("Terminando "+getName());
    }
}
