package chapter07;

import java.util.Scanner;
/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메세지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem {
	//Field
	String admin;
	Student student;
    Scanner scan = new Scanner(System.in);
    Student[] sList = new Student[3];
    int i = 0;
	//Constructor
	public ScoreMgmSystem() {
		
	}
	//Method
	public void insert() {
		for(int i=0;i<sList.length;i++) {
		student = new Student();
		System.out.print("학생명> ");
		student.name = scan.next();
		System.out.print("국어> ");
		student.kor = scan.nextInt();
		System.out.print("영어> ");
		student.eng = scan.nextInt();
		System.out.print("수학> ");
		student.math = scan.nextInt();
		sList[i]=student;
		System.out.print("계속 입력하시겠습니다(계속:아무키나누르세요, 종료:n) > ");
	
		if(scan.next().equals("n")) { 
//			break; 
			i = sList.length;
			System.out.println("=> 등록 완료!! ");
		}
		}
	}
	public void show() {
		System.out.println("---------------------------------------");
		System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("---------------------------------------");
			System.out.print(student.name +"\t");
			System.out.print(student.kor +"\t");
			System.out.print(student.eng +"\t");
			System.out.print(student.math +"\t");
			System.out.print(student.getTot() +"\t");
			System.out.print(student.getAvg() +"\n");
			System.out.println("---------------------------------------");
	}
	public void update() {
		System.out.println("update");
	}
	public void remove() {
		System.out.println("remove");
	}
	public void search() {
		System.out.println("search");
	}


}
