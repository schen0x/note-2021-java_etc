import java.util.ArrayDeque;
import java.util.Iterator;

public class Cp24_ArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> a = new ArrayDeque<>();
        a.offer("a");
        a.offer("b");
        a.offer("c");
        a.offer("d");
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(a.peek()); // "a"

        System.out.println("----------");
        Iterator<String> it = a.iterator();
        System.out.println(it.next() + it.next());
        System.out.println(a.peek()); // "a"
    }
}