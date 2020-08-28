import java.util.stream.Stream;

class Cp31_StreamReduceAndTrivia {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(3, 5, 6);
        Stream<Integer> stream2 = Stream.of(3, 5, 6);
        System.out.println(stream1.reduce(1, (a, b) -> a * b));
        System.out.println(stream2.reduce((a, b) -> a * b));
    }
}
