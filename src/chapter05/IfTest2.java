package chapter05;

import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수> ");
		int score = scan.nextInt();
		
		System.out.println("--시험시작--");
		
		//학점 출력 : 95점이상(A+), 90점이상(A), 85점이상(B+), 80점이상(B)... 60점이하(F)
		
		if(score >= 95) {
			System.out.println("A+");
	} else if(score >= 90) {
		System.out.println("A");
	} else if(score >= 85) {
		System.out.println("B+");
	} else if(score >= 80) {
		System.out.println("B");
	} else if(score >= 75) {
		System.out.println("C+");
	} else if(score >= 70) {
		System.out.println("C");
	} else if(score >= 65) {
		System.out.println("D");
	} else {
		System.out.println("F");
	}
		System.out.println("--시험종료--");
	}
}
