import java.util.List;

public class Cp16_WildcardCapture {
    /**
     * In some cases, the compiler infers the type of a wildcard. E.g., for List<?>
     * l, when evaluating the expression, the compiler infers a particular type from
     * the code. This scenario is known as wildcard capture. An compiler error is
     * thrown when the comipler fails to do so. In such cases, type safety could not
     * be insured if compile continues.
     */
    void fooCompileError(List<?> l) {
        // ! l.set(0, l.get(0)); // compile error
    }

    /**
     * Helper method created so that the wildcard can be captured through type
     * inference. Since T is of "some type" when inputted, type safety could be
     * guaranteed by simply make sure the output type equals to the input type.
     * 
     * @param <T>
     * @param l
     */
    @SuppressWarnings("unused")
    private static final <T> void fooHelperCaptureTheWildcard(List<T> l) {
        l.set(0, l.get(0));
    }
}