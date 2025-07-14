package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
//		Client c1 = new Client(); //abstract 클래스이므로 객체 생성 불가!!!
		Person lee = new Person();
		Person kim = new Person("김유신", "종로구", "010-9876-9876", 20);
		Animal dog = new Animal("명수", 5, lee);
		Animal cat = new Animal("야옹이", 6, kim);
		
//		c1.name = "홍길동";
//		p1.name = "홍길동"; //부모인 Client의 name 변수 사용
//		a1.name = "예삐";
		
		
		
//		c1.printInfo();
		lee.printInfo();
		kim.printInfo();
		dog.printInfo();
		cat.printInfo();
		
		lee.register();
		kim.register();
		
		dog.sound();
		cat.sound();
		

	}

}
