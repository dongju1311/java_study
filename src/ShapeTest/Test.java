package ShapeTest;

public class Test {

	public static void main(String[] args) {
		Circle c1 = new Circle("파란색", 4);
		Rectangle r1 = new Rectangle("초록색", 10, 20);
		Triangle t1 = new Triangle("빨간색", 20, 30);
		
		System.out.println("c1.getArea(); : " + c1.color + c1.getArea());
		System.out.println("r1.getArea(); : " + r1.color + r1.getArea());
		System.out.println("t1.getArea(); : " + t1.color + t1.getArea());
		

	}

}
