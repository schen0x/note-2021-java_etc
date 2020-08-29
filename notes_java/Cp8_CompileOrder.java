class Cp8_CompileOrder_Base00{
    Cp8_CompileOrder_Base00(){
	System.out.println("Base00Constructor");
    }
    static void base00Static(){
	System.out.println("base00StaticMethod");
    }
}
class Cp8_CompileOrder_Base01{
    Cp8_CompileOrder_Base01(){
	System.out.println("Base01Constructor");
    }
    static void base01FirstMethod(){
	System.out.println("base01FirstMethod");
    }
}
@SuppressWarnings("all")
class Cp8_CompileOrder_Extend01 extends Cp8_CompileOrder_Base01{
    Cp8_CompileOrder_Extend01(){
	System.out.println("Extend01Constructor");
    }
    private static void extend01SecondMethod(){ // not called
	System.out.println("extend01SecondMethod"); 
    }
}
@SuppressWarnings("all")
public class Cp8_CompileOrder{
    Cp8_CompileOrder(){
	System.out.println("Cp8_CompileOrderConstructor"); // not called
    }
    public static void main (String[] args){
	Cp8_CompileOrder_Base00.base00Static(); //a static method is called. but the constructor is not loaded.
	System.out.println("Cp8_CompileOrderMain");
	Cp8_CompileOrder_Extend01 x = new Cp8_CompileOrder_Extend01();
	x.base01FirstMethod();
    }
}
