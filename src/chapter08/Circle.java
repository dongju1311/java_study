package chapter08;

public class Circle extends Shape {
	String color;
	int radius;
	public static final double PI = 3.14;
	
	public Circle() {
		
	}
	
	public Circle(String color, int radius) {
		this.color = color;
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	}
	@Override
	public double getArea() {
		return PI*radius*radius;
	}
	
}
