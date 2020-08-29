@SuppressWarnings("all")
class Cp13_MyException_SimpleException extends Exception {
    public Cp13_MyException_SimpleException() {
        super();
    }

    public Cp13_MyException_SimpleException(String msg) {
        super(msg);
    }
}


@SuppressWarnings("all")
class Cp13_MyException_HighlevelException extends Exception {
}


public class Cp13_MyException {
    public void f(String msg) throws Cp13_MyException_SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new Cp13_MyException_SimpleException();
    }

@SuppressWarnings("all")
    public static void main(String[] args) {
        Cp13_MyException sed = new Cp13_MyException();
        try {
            try {
                sed.f("mmmmsg");
            } catch (Cp13_MyException_SimpleException e) {
                e.printStackTrace(System.err);
                System.out.println("++++++++++");
                throw (Cp13_MyException_HighlevelException) new Cp13_MyException_HighlevelException().initCause(e);
            }
        } catch (Cp13_MyException_HighlevelException h) {
            h.printStackTrace(System.err);
            System.out.println((double) new Integer(9));
        }
    }
}
