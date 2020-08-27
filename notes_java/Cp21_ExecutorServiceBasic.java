import java.util.concurrent.*;

public class Cp21_ExecutorServiceBasic {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin"); // in "main" thread
            service.execute(() -> System.out.println("Printing zoo inventory"));
            //! service.shutdown(); // java.util.concurrent.RejectedExecutionException on next line
            service.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println("Printing record: " + i);
            });
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end"); // in "main" thread
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}