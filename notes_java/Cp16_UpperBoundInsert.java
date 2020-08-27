import java.util.*;

class Cp16_UpperBoundInsertAnatidae {
    public void swim() {
        System.out.println("Anatidae swim.");
    }
}

class Cp16_UpperBoundInsertDuck extends Cp16_UpperBoundInsertAnatidae {
    @Override
    public void swim() {
        System.out.println("Duck swim.");
    }

    public void fly() {
        System.out.println("Duck fly.");
    }
}

@SuppressWarnings("unused")
public class Cp16_UpperBoundInsert {
    public static void process(List<? extends Cp16_UpperBoundInsertAnatidae> list) {
        for (Cp16_UpperBoundInsertAnatidae a : list) {
            a.swim();
        }
        Cp16_UpperBoundInsertAnatidae a = new Cp16_UpperBoundInsertAnatidae();
        // ! list.add(a); // compile error
    }


    void fooLowerBound2(List<? super Cp16_UpperBoundInsertDuck> l) {
        // ! l.add(new Cp16_UpperBoundInsertAnatidae());
        l.add(new Cp16_UpperBoundInsertDuck());
    }

    // ! Cannot add an object, however possible to pass a List<Object> l as an arg
    void fooLowerBound3(List<? super String> l) {
        l.add("abc");
        Object o = (Object) "efg";
        // ! l.add(o);
    }

    void fooUpperBound4(List<? extends Object> l) {
        Object o = (Object) "efg";
        // ! l.add(o);
    }

    // <T> void fooUpperBound5(List<T extends Object> l) {
    <T> T T(List<T> T) {
        return T.get(0);
    }

    <T> void ff(T t) {
        Object[] ol = new String[2];
        Object o = t;
        // ! T[] ta = new T[2]; //cannot create generic array
    }

    public static void main(String[] args) {
        // List<Cp16_UpperBoundInsertAnatidae> list = new ArrayList<>();
        // process(list); // "capture of" error. on line 24 list.add(a);
        List<Integer> list2 = new ArrayList<>();
        // foo(list2);
        list2.add(1);
        Cp16_UpperBoundInsert c = new Cp16_UpperBoundInsert();
    }
}
