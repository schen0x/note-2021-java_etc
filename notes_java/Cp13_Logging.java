import java.io.*;
import java.util.logging.*;

// My customized exception
@SuppressWarnings("all")
class Cp13_Logging_ACustomizedException extends Exception {
    private static Logger logger = Logger.getLogger("Static Logger in class ACustomizedException");

    public Cp13_Logging_ACustomizedException() {
        super();
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public Cp13_Logging_ACustomizedException(String msg) {
        super(msg);
    }
}


public class Cp13_Logging {
    public void f() throws Cp13_Logging_ACustomizedException {
        throw new Cp13_Logging_ACustomizedException();
    }

    // A customized method, for catching exceptions written by someone else.
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    // A private logger is needed.
    private static Logger logger = Logger.getLogger("static log in Cp13_Logging class");

    public static void main(String[] args) {
        Cp13_Logging sed = new Cp13_Logging();
        try {
            sed.f();
        } catch (Cp13_Logging_ACustomizedException e) {
            // System.err.println("catch" + e);
            e.printStackTrace(System.err);
            System.out.println();
            logException(e);
        }
        System.out.println();
        System.out.println();
        try {
            throw new Cp13_Logging_ACustomizedException("ccLogMessage For testing");
        } catch (Cp13_Logging_ACustomizedException e) {
            // e.printStackTrace(System.err);
            logException(e);
        }
        System.out.println();
        System.out.println();
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }

    }
}
