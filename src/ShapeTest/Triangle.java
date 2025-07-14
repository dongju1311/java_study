package ShapeTest;

public class Triangle extends Shape implements ShapeInterface{
//	String color;
	int height;
	int width;
	
	public Triangle(String color, int height, int width) {
		super(color);
		this.height = height;
		this.width = width;
	}
	
	public void draw () {
		
	}
	
	public double getArea() {
		return (height*width)/2;
	}
	
	
}
