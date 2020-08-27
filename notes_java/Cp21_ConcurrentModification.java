import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cp21_ConcurrentModification implements Runnable {

    @Override
    public void run() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.print(item + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println(list);
        System.out.println("CopyOnWriteArrayList Size: " + list.size());
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        ExecutorService service2 = null;
        try {
            service = Executors.newFixedThreadPool(4);
            service.submit(new Cp21_ConcurrentModification());
        } finally {
            if (service != null)
                service.shutdown();
        }

        try {
            service = Executors.newFixedThreadPool(4);
            service.submit(() -> {
                List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
                for (Integer item : list) {
                    System.out.print(item + " ");
                    list.remove(item);
                    System.out.println(list);
                }
                System.out.println();
                System.out.println(list);
                System.out.println("CopyOnWriteArrayList Size: " + list.size());
            });
        } finally {
            if (service != null)
                service.shutdown();
        }

        System.out.println("----------------");
        try {
            service2 = Executors.newFixedThreadPool(5);
            service2.submit(() -> {
                List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 52));
                try {
                    for (Integer item : list) {
                        System.out.print(item + " ");
                        list.add(item);
                        System.out.println(list);

                    }
                } catch (ConcurrentModificationException e) {
                    System.out.println(e); // will be ignored if not catch.
                }
                System.out.println();
                System.out.println(list);
                System.out.println("normal arrayList Size: " + list.size());
            });
        } finally {
            if (service2 != null)
                service2.shutdown();
        }
    }

}
