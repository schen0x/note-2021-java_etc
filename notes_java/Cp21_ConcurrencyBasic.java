import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cp21_ConcurrencyBasic {
    private int sheepCountBasic = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCountBasic) + " ");
    }
    public int getSheepCountBasic(){
        return this.sheepCountBasic;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
            Cp21_ConcurrencyBasic manager = new Cp21_ConcurrencyBasic();
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if (service != null){
                // service.shutdown();
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
                System.out.println("-------------------");
                System.out.println(manager.getSheepCountBasic()); //might be less than 100 due to the collision
                System.out.println(service.isTerminated());
            }
        }
    }

}