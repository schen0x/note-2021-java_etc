import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class test2 implements Runnable {

    @Override
    public void run() {
        List<Integer> l = new ArrayList<>();
        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(2));
        for (Integer i : l) {
            l.remove(i);
        }
    }

    // Gulp! the exception is not reported
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(3);
        try {
            e.execute(new test2());
        } finally {
            e.shutdown();
            e.awaitTermination(100, TimeUnit.MICROSECONDS);
        }
    }
}
