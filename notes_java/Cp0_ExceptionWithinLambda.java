import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

class Cp0_ExceptionWithinLambda {
    public static void useSupplier(Supplier<Integer> expression) {}
    public static void useCallable(Callable<Integer> expression) {}
    public static void main(String[] args) {
        useSupplier(() ->{
            //! Files.lines(Paths.get("notadoc", "not")); //unhandled IOException
            return 3;
        });
        useCallable(() ->{
            Files.lines(Paths.get("notadoc", "not")); //compile
            return 3;
        });
        } 
    } 