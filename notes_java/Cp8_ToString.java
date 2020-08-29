class Cp8_ToString_Temp{
    private String s;
    Cp8_ToString_Temp() {
	s = "the temp's constructor";
    }
    public String toString() {
	return
	    s + "and toString overloadiXCX";
    }
}
public class Cp8_ToString{
    public static void main (String[] args){
	Cp8_ToString_Temp x = new Cp8_ToString_Temp();
	System.out.println(x);
    }
}
