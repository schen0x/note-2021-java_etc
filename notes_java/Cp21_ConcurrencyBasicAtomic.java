import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Cp21_ConcurrencyBasicAtomic {
    private AtomicInteger sheepCountAtomic = new AtomicInteger(0);

    private void incrementAndReportAtomic() {
        System.out.print((sheepCountAtomic.incrementAndGet()) + " ");
    }

    public AtomicInteger getSheepCAtomicInteger() {
        return this.sheepCountAtomic;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Cp21_ConcurrencyBasicAtomic manager = new Cp21_ConcurrencyBasicAtomic();
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++)
                service.submit(() -> manager.incrementAndReportAtomic());
        } finally {
            if (service != null) {
                service.shutdown();
                service.awaitTermination(100, TimeUnit.MILLISECONDS);
                System.out.println();
                System.out.println("-------------------");
                System.out.println(manager.getSheepCAtomicInteger()); // always 100
                System.out.println(Runtime.getRuntime().availableProcessors());
                System.out.println(Runtime.getRuntime().freeMemory());
                System.out.println(Runtime.getRuntime().totalMemory());
                System.out.println(Runtime.getRuntime().maxMemory());
            }
        }
    }

}