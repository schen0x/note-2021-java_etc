import java.util.stream.Stream;

class Cp0_StreamChainingTrivia_bean {
    String name;

    public Cp0_StreamChainingTrivia_bean(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}

@SuppressWarnings("all")
public class Cp0_StreamChainingTrivia {
    public static void main(String[] args) {
        Stream<Cp0_StreamChainingTrivia_bean> stream =Stream.of(new Cp0_StreamChainingTrivia_bean[] { new Cp0_StreamChainingTrivia_bean("a"), new Cp0_StreamChainingTrivia_bean("b") });
        stream.peek(Cp0_StreamChainingTrivia_bean::printName); // 1. do nothing
        // 2. but it throws exception later, if the stream been called again.
        // to be specific, it throws:
        // java.lang.IllegalStateException: stream has already been operated upon or closed

        // chaining method like peek() in stream class basically returns a new
        // stream obj, hence the old obj will not be available if the reference
        // is not updated.
        stream = stream.peek(Cp0_StreamChainingTrivia_bean::printName).peek(Cp0_StreamChainingTrivia_bean::printName); 
        stream.forEach(Cp0_StreamChainingTrivia_bean::printName);
    }
}
