package chapter05;

import java.util.Scanner;

/*
 * 단일 iF문 : 조건의 결과가 true인 경우에만 실행함.
 * if~else : 조건의 결과가 true/false 경우에 각각 실행함.
 * 형식) if(조건식) {실행문;} else {실행문;}
 * if~else if~...~else : 여러개의 조건을 체크하여 실행함, 모든 조건에 만족하지 않는 경우 else가 실행됨
 * 형식) if(조건식1) {
 *        조건식1이 true인 경우 실행문;
 *        } else if(조건식2) {
 *        조건식2이 true인 경우 실행문;
 *        } ...
 *        } else {
 *        위의 모든 조건이 false인 경우 실행문;
 *        }
 * 각 if문의 실행문이 한줄인 경우에는 {}(블록)을 생략할 수 있음.
 */
public class IfTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수> ");
		int score = scan.nextInt();
		
		System.out.println("--시험시작--");
		
		//합격 여부 출력 : 60점 이상의 점수를 획득한 경우에만 출력
		if(score >= 60) { System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		System.out.println("--시험종료--");
	}

}
