public class Cp0_GenericFunctionAutoboxing {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Float jF = 2.5f;
        //! Double jD = (Double) jF; //the reference type cannot be cast or auto casted.
        //! Double jD = jF;
        Integer jI = 1;
        //! Long jL = jI; //same error
        float jf = 2.5f;
        double jd = jf; //primitive type, OK
        //-----------------------------------

        Integer iI = 1;
        Long iL = 2L;
        System.out.println(iI + iL); //OK

        //! java.util.function.BiFunction<Integer, Float, Double> f = (n1, n2) -> n1 + n2; //cannot convert from float to Double
        // System.out.println(f.apply(1, 2.5F));
    }
}