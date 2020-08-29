class Cp5_Overloading_Base{
    int i = 0;
    Cp5_Overloading_Base(){ //constructor
	i = 1;
    }
    Cp5_Overloading_Base(int j){ //overload constructor
	i = j;
    }
    public void method(){ //method
	double k = i + i;
	System.out.println("i + i = " + k);
    }
    public void method(String str2){ //method1 overload
	double k = i * i;
	System.out.println("i * i = " + k);
    }
}
public class Cp5_Overloading{
    public static void main (String[] args){
	Cp5_Overloading_Base a = new Cp5_Overloading_Base();
	a.method();
	a.method("rock");
	Cp5_Overloading_Base b = new Cp5_Overloading_Base(12);
	b.method();
	b.method("rock");
    }
}
