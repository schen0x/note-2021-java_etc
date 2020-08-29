import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cp0_PrimitiveStreamTrivia {
    static void f(Integer... i){
        System.out.println(i[0]);
    }
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Integer[] a = {
            Integer.valueOf(1),
            Integer.valueOf(2),
        };
        Stream.of(a).forEach(System.out::println);
        f(a);
        
        //will not auto convert to IntStream.
        //! IntStream iS0 = Arrays.stream(a);
         Stream<Integer> iS0 = Arrays.stream(a);

        //However if elements are primitive, will do.
        IntStream is1 = Arrays.stream(new int[]{1,2,3});
        //Even if null, elements will be inited to 0, no null pointer exception.
        IntStream is2 = Arrays.stream(new int[3]);
        is2.forEach(System.out::println);
        // System.out.println(iS2.sum());
    }
}
