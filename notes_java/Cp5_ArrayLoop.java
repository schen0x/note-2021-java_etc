public class Cp5_ArrayLoop{
    public static void main (String[] args){
	Cp5_ArrayLoop_Other.main(new String[] {"ah", "ha", "ha" });
    }
}
class Cp5_ArrayLoop_Other{
    public static void main (String[] args){
	System.out.println(args);
	for(String x : args)
	    System.out.print(x + "");
    }
}

