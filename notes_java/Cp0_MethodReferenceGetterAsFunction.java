import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class Cp0_MethodReferenceGetterAsFunctionBean {
    private String name;

    public Cp0_MethodReferenceGetterAsFunctionBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class Cp0_MethodReferenceGetterAsFunction {
    public static void main(String[] args) {
        List<Cp0_MethodReferenceGetterAsFunctionBean> beanList = Arrays.asList(
            new Cp0_MethodReferenceGetterAsFunctionBean("a"),
            new Cp0_MethodReferenceGetterAsFunctionBean("b")
        );

        Function<Cp0_MethodReferenceGetterAsFunctionBean, String> f = Cp0_MethodReferenceGetterAsFunctionBean::getName;
        // Function<Cp0_MethodReferenceGetterAsFunctionBean, String> fEquivalent =
        //     (Cp0_MethodReferenceGetterAsFunctionBean x) -> x.getName();
        
        beanList.stream()
            .map(f)
            .forEach(System.out::println);
    }
    /**
     * if the desugared method is an instance method, the receiver is
     * considered to be the first argument)
     * search for:
     * 1. Arrays.sort(stringArray, String::compareToIgnoreCase);
     * 2. Translation of Lambda Expressions (Brian Goetz, 2012);
     * 3. doc.oracle.com "methodreference.html" //in which 4 types of method reference is listed.
     */
}