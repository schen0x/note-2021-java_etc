interface Cp11_Callback_Incrementable {
    void increment();
}


// Very simple to just implement the interface:
class Cp11_Callback_Callee1 implements Cp11_Callback_Incrementable {
    private int i = 0;

    public void increment() {
        i++;
        System.out.println(i);
    }
}


class Cp11_Callback_MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(Cp11_Callback_MyIncrement mi) {
        mi.increment();
    }
}


// If another implementation of increment() is desired, must use an inner class:
class Cp11_Callback_Callee2 extends Cp11_Callback_MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Cp11_Callback_Incrementable {
        public void increment() {
            // Specify outer-class method, otherwise infinite recursion occurs.
            Cp11_Callback_Callee2.this.increment();
        }
    }

    Cp11_Callback_Incrementable getCallbackReference() {
        return new Closure();
    }

    Cp11_Callback_Incrementable getCallbackReference2() {
        return new Cp11_Callback_Incrementable() {
            public void increment() {
                Cp11_Callback_Callee2.this.increment();
                System.out.println(
                        "Anonymous class or lambda new class can also access methods in the enclosing class, e.g. use the EnclosingClass.this.methodName();");
            }
        };
    }
}



class Cp11_Callback_Caller {
    private Cp11_Callback_Incrementable callbackReference;

    Cp11_Callback_Caller(Cp11_Callback_Incrementable input) {
        callbackReference = input;
    }

    void go() {
        callbackReference.increment();
    }
}


public class Cp11_Callback {
    public static void main(String[] args) {
        Cp11_Callback_Callee1 c1 = new Cp11_Callback_Callee1();
        Cp11_Callback_Callee2 c2 = new Cp11_Callback_Callee2();
        Cp11_Callback_MyIncrement.f(c2);
        Cp11_Callback_Caller caller1 = new Cp11_Callback_Caller(c1);
        Cp11_Callback_Caller caller2 = new Cp11_Callback_Caller(c2.getCallbackReference());
        Cp11_Callback_Caller caller22 = new Cp11_Callback_Caller(c2.getCallbackReference2());
        caller1.go();
        caller1.go();
        // caller2.go();
        caller2.go();
        caller22.go();
        caller22.go();
        caller22.go();
    }
}
