package chapter04;
/*
 * 증감 연산자 = ++, --
 */
public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;
		
		System.out.println(++number); //11
		System.out.println(number++); //11 (표시는 11이나 후위이기 때문에 메모리에는 12로 저장)
		System.out.println(number); //12

		System.out.println(--number); //11
		System.out.println(number--); //11(표시는 11이나 후위이기 때문에 메모리에는 10으로 저장)
		System.out.println(number); //10
		

	}

}
