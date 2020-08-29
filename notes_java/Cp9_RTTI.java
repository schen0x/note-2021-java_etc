class Cp9_RTTI_Useful {
    public void f() {
    }

    public void g() {
    }
}

class Cp9_RTTI_MoreUseful extends Cp9_RTTI_Useful {
    public void f() {
    }

    public void g() {
    }

    public void u() {
    }

    public void v() {
    }
}

public class Cp9_RTTI {
    public static void main(String[] args) {
        Cp9_RTTI_Useful[] x = { new Cp9_RTTI_Useful(), new Cp9_RTTI_MoreUseful() };
        x[0].f();
        x[1].g();
        System.out.println();
        ((Cp9_RTTI_MoreUseful) x[0]).u(); // ClassCastException thrown
        ((Cp9_RTTI_MoreUseful) x[1]).u(); // RTTI
    }
}
