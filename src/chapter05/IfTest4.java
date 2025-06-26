package chapter05;
/*
 * 중첩 if
 */
import java.util.Scanner;

public class IfTest4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean math_pass = false, eng_pass = false;
		
		System.out.print("수학점수> ");
		math_pass=(scan.nextInt() >= 60)? true: false;
		System.out.print("영어점수> ");
		eng_pass=(scan.nextInt() >= 60)? true: false;
		
		//1. 중첩 if
		if(math_pass) if(eng_pass)System.out.println("합격"); 
		else System.out.println("불합격");
		
		//2. 논리연산자 &&를 이용하여 if ~ else
		if((math_pass) && (eng_pass)) System.out.println("합격");
		else System.out.println("불합격");
		
		
	
}
}
