package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {
		
		// 배열 객체 선언 - 1에서 20까지의 데이터를 저장 후 순서대로 출력
		int[] numbers = new int[20]; //배열의 전체 크기 : 변수명.length
		
		//데이터 저장
		for(int i =0; i<20; i++) { // i= number.length
			numbers[i] = i + 1; //numbers[0] = 1; ...
		}
		
//		numbers[0] = 1;
//		numbers[1] = 2;
//		numbers[2] = 3;
//		numbers[3] = 4;
//		numbers[4] = 5;
		
		//데이터 출력
		for(int j = 0; j<20; j++) {
			System.out.println(numbers[j]);
		}
		
//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]);
//		

	}

}
