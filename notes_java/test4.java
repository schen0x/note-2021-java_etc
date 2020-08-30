import java.util.stream.Stream;

public class test4 {
    public static void main(String[] args) {
        Stream.of(1,2,3)
            .limit(5)
            .forEach(System.out::println);
    }
}