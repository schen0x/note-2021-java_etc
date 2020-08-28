interface Cp0_DoubleColonOperatorExample2Flyable {
    Cp0_DoubleColonOperatorExample2Plane getPlane(String name);
    // ! void doRandomShet(); // line class::new will not run if not functional interface.
}

@SuppressWarnings("unused")
public class Cp0_DoubleColonOperatorExample2 {
    public static void main(String[] args) {
        Cp0_DoubleColonOperatorExample2Flyable f1 = Cp0_DoubleColonOperatorExample2Plane::new; // Only legal for functional interface
        // the signature on the right rhs method(if overloaded), is found using params on the lhs.
        // i.e., in the lhs -- the flyable.getPlane method, we already know:
        // 1. desired return type;
        // 2. desired parameters (the String name).
        // so we are able to find the right new function.
        Cp0_DoubleColonOperatorExample2Flyable f2 = new Cp0_DoubleColonOperatorExample2Flyable() {
            @Override
            public Cp0_DoubleColonOperatorExample2Plane getPlane(String name) {
                return new Cp0_DoubleColonOperatorExample2Plane(name);
            }
        };
    }
}

@SuppressWarnings("unused")
class Cp0_DoubleColonOperatorExample2Plane {
    private String name;

    Cp0_DoubleColonOperatorExample2Plane(String name) {
        this.name = name;
    }
}