package chapter03;

import java.util.Scanner;

public class TestMenu {

	public static void main(String[] args) {
		System.out.println("********************************************");
		System.out.println("\n\tWelcomt to Shopping Mall");
		System.out.println("\n\tWelcomt to Food Market");
		System.out.println("\n********************************************");
		System.out.println("\n\t1. 상품보기\t2.상품구입");
		System.out.println("\n\t3. 영수증보기\t4.종료");
		
	
		Scanner scan = new Scanner(System.in);

		System.out.print("\n메뉴를 선택하세요(숫자) >");
		
		String menunumber = scan.next(); 
		
		System.out.println("선택한 메뉴 =" + menunumber);
		
		
	}

}
