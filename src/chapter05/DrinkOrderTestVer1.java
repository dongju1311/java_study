package chapter05;

import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		// 지역변수 선언
		Scanner scan = new Scanner(System.in);
		int menuNu = -1;
		String menuName = "";
		boolean menuFlag = true;
		boolean payment = true;
		int menuPrice = 0;
		String menuPriceOutPut = "";
		String chargeOutPut = "";
		String changeOutPut = "";
		int charge = 0;
		int change = 0;
		
		//step 1. 메뉴판 출력
		System.out.println("[시작]");
		System.out.println("-------------------------------------");
		System.out.println("\t☕🍵🥤 Mega Coffee Menu");
		System.out.println("-------------------------------------");
		System.out.println("1. ☕ 아메리카노 - 2,800원");
		System.out.println("2. 🍵 바닐라라떼 - 3,500원");
		System.out.println("3. 🥤 딸기라떼 - 4,000원");
		System.out.println("-------------------------------------");

		//step 2. 메뉴주문
		while(menuFlag) {
			System.out.print("주문할 메뉴 번호 입력(숫자)> ");
			if(scan.hasNextInt()) {
				//선택한 메뉴번호에 따라 메뉴명, 가격을 별도의 변수에 저장
				menuFlag = false;
			    menuNu = scan.nextInt();
				switch(menuNu) {
			    case 1: menuName = "☕ 아메리카노"; menuPrice = 2800; break;
			    case 2: menuName = "🍵 바닐라라떼"; menuPrice = 3500; break;
			    case 3: menuName = "🥤 딸기라떼"; menuPrice = 4000; break;
			    default: 
			    	System.out.println("=> 준비중입니다.");
			    	menuFlag = true;
			    }// switch
				//출력용 메뉴가격 저장
				menuPriceOutPut = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
				} else {
				System.out.println("올바르지 않은 값입니다. 다시 입력해주세요.");
				scan.next();
			}// if
		}// while-menuFlag
		System.out.println("=> 주문 메뉴 : " +menuNu+ " 결제 예정 금액 " +menuPrice+ "입니다.");
		System.out.println("---step1종료---");
		//step 3. 결제기능
		while(payment) {
			payment = false;
			System.out.print("결제할 금액 입력 > ");
			if(scan.hasNextInt()) {
				charge += scan.nextInt();
				System.out.println("총 입금 금액 " + charge + "원 입니다.");
				chargeOutPut = String.format("%,d", new Object[] {Integer.valueOf(charge)});
				changeOutPut = String.format("%,d", new Object[] {Integer.valueOf(change)});
				if(charge >= menuPrice) {
					change = charge - menuPrice;
				} else {
					payment = true;
					System.out.println("금액이 부족합니다. 다시 입력해주세요.");					
				}
			} else {
				System.out.println("올바르지 않은 입력값입니다.");
				scan.next();
			}// if
		}// while
		System.out.println("결제완료! 잔돈 " + change + " 원 입니다.");
		System.out.println("[종료]");
		System.out.println("[이용해주셔서 감사합니다.]");
	}// main

}// class
