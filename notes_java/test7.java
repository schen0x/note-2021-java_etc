enum test7_base{
    A{void f(){
        super.f();
        System.out.println("childhi");
    }};
    void f(){
        System.out.println("hi");
    }
}
public class test7 {
    public static void main(String[] args) {
       test7_base.valueOf("A").f();
    }
}