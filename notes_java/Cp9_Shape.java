class Cp9_ShapeBaseShape{
    void draw(){
	System.out.println("Shape.draw");
    }
}
class Cp9_ShapeCircle extends Cp9_ShapeBaseShape{
    void draw(){
	System.out.println("Circle.draw");
    }
    void drawP(){
	System.out.println("Circle.drawP");
    }
}
public class Cp9_Shape{
    public static void main (String[] args){
	Cp9_ShapeBaseShape x = new Cp9_ShapeCircle();
	x.draw();
	System.out.println(x.getClass()); //Class Circle
	Cp9_ShapeCircle y = new Cp9_ShapeCircle();
	y.drawP();
	//! x.drawP(); //cannot find symble
    }
}
