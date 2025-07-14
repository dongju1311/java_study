package ShapeTest;

public class Circle extends Shape implements ShapeInterface{
//	String color;
	int radius;
	final static double PI = 3.14;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	}
	@Override
	public double getArea() {
		return radius*radius*PI;
	}
}
