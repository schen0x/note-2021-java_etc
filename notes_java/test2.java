import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class test2 {
    public static void main(String[] args) {
        int x = 1;
        IntFunction<IntFunction<String>> f = b -> i -> String.valueOf(i + x + b);
        IntStream.of(1,2,3)
            .mapToObj(f.apply(10))
            .forEach(System.out::println);
    } 
}