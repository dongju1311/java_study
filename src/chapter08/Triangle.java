package chapter08;

public class Triangle extends Shape implements ShapeInterface{
//	String color;
	int height;
	int width;
	
	
	public Triangle(String color, int height, int width) {
		super(color);
		this.height = height;
		this.width = width;
	}
	

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	}
	@Override
	public double getArea() {
		return (height*width)/2;
	}
	
}
