import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cp21_ConcurrentCollections {
    private Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();

    public void put(String key, String value) {
        foodData.put(key, value);
    }

    public Object get(String key) {
        return foodData.get(key);
    }

    public synchronized Map<String, Object> getFoodData(){
        return this.foodData;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Cp21_ConcurrentCollections manager = new Cp21_ConcurrentCollections();
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++) {
                final Integer ir = Integer.valueOf(i);
                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        manager.put("key" + ir, "v");
                    }
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
                service.awaitTermination(100, TimeUnit.MILLISECONDS);
                System.out.println();
                System.out.println("-------------------");
                System.out.println(manager.getFoodData().get("key99"));
            }
        }
    }
}
