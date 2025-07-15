package zoo;

/**
 * Animal 클래스를 상속받은 자식 클래스 정의
 */

public class Lion extends Animal {
	
	public Lion() {
		this("심바", 5);
	}
	
	public Lion(String name, int age) {
		super(name, age);
	}
	
	public void sleep() {
		System.out.println(name + "이(가) 잠을 잔다.");
	}
	public void eat() {
		System.out.println(name + "이 먹는다.");
	}
	
}
