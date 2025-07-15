package zoo;

public class Tiger extends Animal{
	
	public Tiger () {
		this("호돌이", 3);
	}
	
	public Tiger (String name, int age) {
		super(name, age);
	}
	
	public void sleep() {
		System.out.println(name + "이(가) 잠을 잔다.");
	}
	public void eat() {
		System.out.println(name + "이 먹는다.");
	}
	
}
