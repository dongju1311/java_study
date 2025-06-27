package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		// 구구단 2단 출력
		Scanner scan = new Scanner(System.in);
		int dan = 0;
		
		System.out.println("출력하실 구구단을 입력해주세요");
		System.out.print("dan> ");
		dan = scan.nextInt();
		
		System.out.println(dan+"단");
		System.out.println("-------------");
		
		for(int i = 1; i<=9; i++) {
			System.out.println(dan + " × " + i + " = " + (dan*i));
		}

	}

}
