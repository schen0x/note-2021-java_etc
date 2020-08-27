import java.util.Arrays;

public class Cp21_ParallelStreamBadReduce {
    private void run1() {
        System.out.println(Arrays.asList("w", "o", "l", "f").parallelStream()
            .reduce("X", String::concat)); 
    }
    private void run2() {
        System.out.println(Arrays.asList("w", "o", "l", "f").stream()
            .reduce("X", String::concat)); 
    }
    public static void main(String[] args) {
        Cp21_ParallelStreamBadReduce x = new Cp21_ParallelStreamBadReduce();
        x.run2();
        x.run1(); 
    } 
}