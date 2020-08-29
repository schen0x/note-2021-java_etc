class Cp8_Override_Lisa {
    void method(String str){
	System.out.println(str);
    }
    void method(int i){
	System.out.println(i + i);
    }
}
class Cp8_Override_LisaOverride extends Cp8_Override_Lisa {
    //@Override 
    void method(char c){
	System.out.println("char");
    }
}
    
public class Cp8_Override{
    public static void main (String[] args){
	Cp8_Override_LisaOverride x = new Cp8_Override_LisaOverride();
	char c = 'C';
	int i = 9;
	x.method(c);
	x.method(i);
	    
    }
}
