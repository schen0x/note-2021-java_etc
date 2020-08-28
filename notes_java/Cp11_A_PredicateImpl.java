import java.util.function.Predicate;

class Cp11_A_PredicateImpl {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Predicate<String> p = new java.util.function.Predicate<String>(){
            @Override
            public boolean test(String arg0) {
                System.out.println(arg0);
                return false;
            }
        };
    }
}
