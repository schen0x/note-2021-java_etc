class Cp7_Private_AClass{
    private Cp7_Private_AClass(){}
    static Cp7_Private_AClass makeAClass(){
	return new Cp7_Private_AClass();
    }
}
public class Cp7_Private{
    /**
       class AClass{
	private AClass(){}
	static AClass makeAClass(){
	    return new AClass(); //non-static variable this cannot be referenced from a static context
	}
       }
    */
	
    public static void main (String[] args){
	Cp7_Private_AClass x = Cp7_Private_AClass.makeAClass();
	System.out.println(x);
    }
}
