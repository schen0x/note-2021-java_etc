import java.util.ArrayList;

class Cp12_ArrayListWithGenericApple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}


class Cp12_ArrayListWithGenericOrange {
}


public class Cp12_ArrayListWithGeneric {
    public static void main(String[] args) {
        ArrayList<Cp12_ArrayListWithGenericApple> apples = new ArrayList<Cp12_ArrayListWithGenericApple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Cp12_ArrayListWithGenericApple());
        // ! apples.add(new Orange()); //Compile time error.
        for (int i = 0; i < apples.size(); i++)
            System.out.println((apples.get(i)).id());
        for (Cp12_ArrayListWithGenericApple c : apples)
            System.out.println(c.id());
    }
}
