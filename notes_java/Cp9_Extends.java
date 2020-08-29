class Cp9_Extends_Base02 {
    void baseMethod() {}
}


class Cp9_Extends_Ext01 extends Cp9_Extends_Base02 {
    void extMethod() {
        System.out.println("extMethod");
    }
    // Does not override because not the same method.
    // @Override
    //    void baseMethod(int i) {
    //        return i;
    //    }
}


public class Cp9_Extends {
    public static void main(String[] args) {
        // polymorphism
        Cp9_Extends_Base02 x = new Cp9_Extends_Ext01();
        x.baseMethod();
        // ! x.extMethod(); This, the downcast does not work.
    }
}
