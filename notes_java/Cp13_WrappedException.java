import java.io.IOException;

@SuppressWarnings("all")
class Cp13_WrappedException_TestMyThrowable extends Throwable {
    Cp13_WrappedException_TestMyThrowable() {
        super();
    }

    Cp13_WrappedException_TestMyThrowable(String message, Throwable cause) {
        super(message, cause);
    }
}


class Cp13_WrappedException_WrappedExceptions {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Cp13_WrappedException_TestMyThrowable();
                case 1:
                    throw new IOException();
                default:
                    return;
            }
        } catch (Throwable t) {
            throw new RuntimeException(t); // RuntimeException(Throwable cause);
        }
    }
}


public class Cp13_WrappedException {

    public static void main(String[] args) {
        Cp13_WrappedException_WrappedExceptions x = new Cp13_WrappedException_WrappedExceptions();
        x.throwRuntimeException(3);
        x.throwRuntimeException(0);
    }
}
