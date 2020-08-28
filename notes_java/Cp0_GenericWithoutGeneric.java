class Cp0_GenericWithoutGenericBase<T> {
    public T get(T t) {
        return t;
    }
}

// Generic class can be used without specifying a generic.
public class Cp0_GenericWithoutGeneric {
    @SuppressWarnings({"unchecked","rawtypes"})
    public static void main(String[] args) {
        Cp0_GenericWithoutGenericBase<String> x = new Cp0_GenericWithoutGenericBase(); // warning
        Cp0_GenericWithoutGenericBase y = new Cp0_GenericWithoutGenericBase(); // warning
        System.out.println(x.get("x"));
        System.out.println(y.get(1.0)); // warning
    }
}