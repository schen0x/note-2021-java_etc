import java.util.*;
import java.io.File;

interface test9i {

}


public class test19 implements test9i {
    void f() {
        System.out.println("f");
    }

    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
        for (String s : ll) {
            System.out.println(s);
        }
        System.out.println(File.separator);
    }
}
