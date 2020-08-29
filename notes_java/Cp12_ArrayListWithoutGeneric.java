import java.util.ArrayList;

class Cp12_ArrayListWithoutGeneric_Apple01 {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}


class Cp12_ArrayListWithoutGeneric_Orange01 {
}

@SuppressWarnings("all")
public class Cp12_ArrayListWithoutGeneric {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList(); // unchecked arrayList initialization.
        for (int i = 0; i < 3; i++)
            apples.add(new Cp12_ArrayListWithoutGeneric_Apple01());
        // Not prevented from adding an Orange01 to apples:
        apples.add(new Cp12_ArrayListWithoutGeneric_Orange01()); // ArrayList takes in Objects, yet Orange01 is also an object.
        for (int i = 0; i < apples.size(); i++)
            ((Cp12_ArrayListWithoutGeneric_Apple01) apples.get(i)).id(); // An Orange01 must be casted into Apple01, then parenthesised
                                          // to force evaluation, then its id() method is called,
                                          // which does not exist in Orange01.
        // Orange01 is detected only at run time
    }
}
