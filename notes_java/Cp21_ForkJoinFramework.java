import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

//Cp21_ForkJoinFramework
public class Cp21_ForkJoinFramework {
    private class Cp21_ForkJoinFrameworkRecursiveAction extends RecursiveAction {
        private static final long serialVersionUID = 1L;
        private int start;
        private int end;
        private Double[] weights;

        public Cp21_ForkJoinFrameworkRecursiveAction(Double[] weights, int start, int end) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        protected void compute() {
            if (end - start <= 3)
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println("Animal Weighed: " + i);
                }
            else {
                int middle = start + ((end - start) / 2);
                System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
                // the invokeAll method return no value.
                invokeAll(new Cp21_ForkJoinFrameworkRecursiveAction(weights, start, middle),
                        new Cp21_ForkJoinFrameworkRecursiveAction(weights, middle, end));
            }
        }
    }

    private class Cp21_ForkJoinFrameworkRecursiveTask extends RecursiveTask<Double> {

        private static final long serialVersionUID = 1L;
        private int start;
        private int end;
        private Double[] weights;

        public Cp21_ForkJoinFrameworkRecursiveTask(Double[] weights, int start, int end) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected Double compute() {
            if (end - start <= 3) {
                double sum = 0;
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println("Animal Weighed: " + i);
                    sum += weights[i];
                }
                return sum;
            } else {
                int middle = start + ((end - start) / 2);
                System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
                RecursiveTask<Double> otherTask = new Cp21_ForkJoinFrameworkRecursiveTask(weights, start, middle);
                // the fork() method instruct the fork/join framework to complete the task in a separate thread.
                otherTask.fork();
                // join() tell the current thread to wait
                return new Cp21_ForkJoinFrameworkRecursiveTask(weights, middle, end).compute() + otherTask.join();
                // hence if join() is called before the current thread start its task, the result would be single threaded.
            }
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Cp21_ForkJoinFramework x = new Cp21_ForkJoinFramework();
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = x.new Cp21_ForkJoinFrameworkRecursiveAction(weights, 0, weights.length);
        // System.out.println(x.new Cp21_ForkJoinFrameworkRecursiveTask(weights, 0, weights.length).compute());
        // System.out.println(x.new Cp21_ForkJoinFrameworkRecursiveTask(weights, 0, weights.length).compute());
        // Since ForkJoinTask is the super class that the RecursiveAction/task class inherit, 
        // the 2 new created 2 different ForkJoinTask.

        // task1
        ForkJoinPool pool = new ForkJoinPool();
        // pool.invoke(task);

        // task2
        ForkJoinTask<Double> task2 = x.new Cp21_ForkJoinFrameworkRecursiveTask(weights, 0, weights.length);
        Double sum = pool.invoke(task2);
        System.out.println("Sum2: " + sum);
        // sum = pool.invoke(task2); // note that submitting same task instance return the same result.
        // System.out.println("Sum2: " + sum);
    }
}