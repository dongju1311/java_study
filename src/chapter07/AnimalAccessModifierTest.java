package chapter07;

import commons.Animal;

public class AnimalAccessModifierTest {

	public static void main(String[] args) {
		//static 변수, static 메소드 호출
		AnimalAccessModifier.sname = "스태틱";
		AnimalAccessModifier.sage = 10;
		AnimalAccessModifier.getInfo3();
		
		
		AnimalAccessModifier aam = new AnimalAccessModifier("호순이", 5);
		aam.sname = "스태틱2";
		aam.age = 12;
		aam.getInfo3();
		
		
		Animal comDog = new Animal();
		
		comDog.setName("예삐");
		comDog.setAge(10);
		
		
//		comDog.name = "예삐"; //패키지가 다르므로 접근 불가 : default(package)
//		comDog.age = 3; 	//패키지가 다르므로 접근 불가 : default(package)
		
		aam.name = "심바";
		aam.age = 5;
		
//		aam.pname = "호순이"; //클래스가 다르므로 접근 불가 : private
//		aam.page = 5;		//클래스가 다르므로 접근 불가 : private
		
		System.out.println("name = " + aam.name);
		System.out.println("age = " + aam.age);
		System.out.println("name = " + aam.getPname());
		System.out.println("age = " + aam.getPage());
		
		System.out.println("name = " + comDog.getName());
		System.out.println("age = " + comDog.getAge());
		
	}

}
