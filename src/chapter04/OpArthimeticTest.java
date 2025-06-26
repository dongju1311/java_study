package chapter04;
/*
 * 사칙 연산자 : +, -, *, /, %
 */
public class OpArthimeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		System.out.println(number1 + number2);
		System.out.println("number1 + number2 = " + number1 + number2);
		//()를 하지 않으면 앞의 연산자를 먼저 따라가기 때문에 주의
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2));
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		
	}

}
