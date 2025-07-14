package ShapeTest;

 abstract public class Shape {
	 String color;
	 
	 protected Shape (String color) {
		 this.color = color;
	 }
	 
	abstract public void draw ();
	abstract public double getArea();
}
