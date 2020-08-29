class Cp9_PolyPitfall_Super {
    public int i = 0;
    public int getI(){return i;}
    static int j = 0;
    public int getJ(){return j;}
}
@SuppressWarnings("all")
class Cp9_PolyPitfall_Sub extends Cp9_PolyPitfall_Super{
    public int i = 1;
    public int getI(){return i;}
    public int getSuperI(){return super.i;}
    static int j = 1;
    public int getJ(){return j;}
    public int getSuperJ(){return super.j;}
}
@SuppressWarnings("all")
public class Cp9_PolyPitfall{
    public static void main (String[] args){
	Cp9_PolyPitfall_Super sup = new Cp9_PolyPitfall_Sub();
	Cp9_PolyPitfall_Sub sub01 = new Cp9_PolyPitfall_Sub();
	System.out.println("sup.i " + sup.i + " sup.getI()" + sup.getI()); //0 1
	System.out.println("sup.j " + sup.j + " sup.getJ()" + sup.getJ()); //0 1
	System.out.printf("sub01.i=%d, j=%2d %n", sub01.i, Cp9_PolyPitfall_Sub.j);
	System.out.println("sub01.getSuperI()" + sub01.getSuperI()); //0
	System.out.println("sub01.getSuperJ()" + sub01.getSuperJ()); //0
    }
}
