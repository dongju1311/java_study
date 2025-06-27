package chapter05;

/*
 * 반복문 : while(조건식) { 실행문(조건식이 true인 경우에만 실행); }
 *        종료되는 시점을 정확하게 알고 있는 경우 사용됨.
 */
public class WhileTest {

	public static void main(String[] args) {
		// 1~10까지 누적값을 출력
		int i = 1;
		int sum = 0;
		
		while(i<=10) {
			sum += i;
			i++; // 10씩 증가하고싶을 때 : i+=10;
			System.out.println("sum= " + sum);
		}

	}

}
