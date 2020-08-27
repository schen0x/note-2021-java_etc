import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * the output is always in natural order.
 */
public class Cp21_ConcurrencyBasicLock {
    private int sheepCountAtomic;

    private void incrementAndReportAtomic1() {
        synchronized (this) {
            System.out.print((++sheepCountAtomic) + " ");
            // printDaysWork1(); // OK
        }
    }

    // same
    @SuppressWarnings("unused")
    private synchronized void incrementAndReportAtomic2() {
        System.out.print((++sheepCountAtomic) + " ");
    }

    // on static method
    public static void printDaysWork1() {
        synchronized (Cp21_ConcurrencyBasicLock.class) {
            System.out.println("Finished work");
        }
    }

    // same
    public static synchronized void printDaysWork2() {
        System.out.println("Finished work");
    }

    public int getSheepCAtomic() {
        return this.sheepCountAtomic;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Cp21_ConcurrencyBasicLock manager = new Cp21_ConcurrencyBasicLock();
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++)
                service.submit(() -> {
                    manager.incrementAndReportAtomic1();
                    Cp21_ConcurrencyBasicLock.printDaysWork2(); //?
                });
        } finally {
            if (service != null) {
                service.shutdown();
                service.awaitTermination(100, TimeUnit.MILLISECONDS);
                System.out.println();
                System.out.println("-------------------");
                System.out.println(manager.getSheepCAtomic()); // always 100

            }
        }
    }

}