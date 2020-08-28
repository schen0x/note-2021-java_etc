enum Cp22_MethodsInEnumElementsEnum{
    enumA{
        @Override
        void f(){
            System.out.println("printing en enumA");
            super.g();
        }
    }, enumB;
    void f(){
        System.out.println("printing in f");
    }
    private void g(){
        System.out.println("printing in enum class private method");
    }
}
class Cp22_MethodsInEnumElements {
    @SuppressWarnings("unused")
    private enum enumP{
        A, B
    }
    public static void main(String[] args) {
        Cp22_MethodsInEnumElementsEnum ea = Cp22_MethodsInEnumElementsEnum.enumA;
        ea.f();
        Cp22_MethodsInEnumElementsEnum eb = Cp22_MethodsInEnumElementsEnum.enumB;
        eb.f();
    }
}
