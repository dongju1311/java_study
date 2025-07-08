package chapter07;

public class Animal2 {
       //Field : 전역변수(알아서 변수 초기화)
	   String name;
	   int age; 
	   //Constructor : 생성자는 오버로딩이 가능함!!
	   public Animal2() { //기본 생성자
		   System.out.println("객체를 생성한다.");
	   }
	   public Animal2(String name) { //Field의 name만 초기화
		   this.name = name;
		   System.out.println("객체를 생성한다.");
	   }
	   public Animal2(String name, int age) { //Field의 name, age 초기화
		   this.name = name;
		   this.age = age;
		   System.out.println("객체를 생성한다.");
	   }
	   //Method
	   public void sleep() { //Method Area
		   System.out.println(name + " -> 잠을 잔다.");
	   }
	   
	   
//	   public static void main(String[] args) {
//		   Animal giraffe = new Animal();
//		   Animal elephant = new Animal();
//		   
//		   giraffe.name = "기린이";
//		   elephant.name = "코순이";
//		   
//		   System.out.println("giraffe.name = " + giraffe.name);
//		   System.out.println("elephant.name = " + elephant.name);
//	   }
}
