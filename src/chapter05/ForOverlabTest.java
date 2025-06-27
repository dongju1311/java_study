package chapter05;

import java.util.Scanner;

/*
 * 중첩 for문
 */
public class ForOverlabTest {

	public static void main(String[] args) {
		// 2단 ~ 5단
		
		Scanner scan = new Scanner(System.in);
		int start= 0, end = 0;
		
		System.out.println("프로그램 종료: start, end 모두 0 입력");
		
		boolean flag = true; 
		
		while(flag) {
			System.out.print("start> ");
			start = scan.nextInt();
			System.out.print("end> ");
			end = scan.nextInt();
			
			//실행 여부 체크
			
			if(start == 0 && end == 0) {
//				while 블록을 빠져 나간 후 종료!!!
//				System.out.println("프로그램 종료");
//				System.exit(0);
				flag = false;
			} else {
				for(int i=1; i<=9; i++) {
				for(int j=start; j<=end; j++) {
					System.out.print(j + "×" + i + "=" + (j*i) + "\t");
				}
				System.out.println();
			}
			System.out.println("프로그램 종료: start, end 모두 0 입력");
		} 
      } //for 블럭
		System.out.println("프로그램 종료");
        System.exit(0);
	} // main 블럭
}
