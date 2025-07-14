package ShapeTest;

public class Rectangle extends Shape implements ShapeInterface{
//	String color;
	int height;
	int width;
	
	public Rectangle (String color, int height, int width) {
		super(color);
		this.height = height;
		this.width = width;
	}
	
	public void draw() {
		
	}
	
	public double getArea() {
		return height*width;
	}
	
}
