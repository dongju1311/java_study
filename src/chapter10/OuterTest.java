package chapter10;

public class OuterTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		System.out.println("outer.name --> "+outer.name);
		Outer.Inner inner = new Outer.Inner();
		System.out.println("Inner.name --> "+inner.name);
	}

}
