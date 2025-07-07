package 실습;

import java.util.Scanner;

import chapter07.LunchMenu;

public class OrderSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] drinkMenuNames = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기쉐이크"};
	int[] drinkMenuPrice = {2800, 3500, 4000};
	Menu[] drinkMenuList = new Menu[3];
	
	
	//Constructor
	//Method
	
	//음료 메뉴 생성
	public void showLunchMenu () {
		System.out.println("===메뉴판===");
		System.out.println("1. ☕ 아메리카노 - 2,800원");
		System.out.println("2. 🍵 바닐라 라떼 - 3,500원");
		System.out.println("3. 🥤 딸기 쉐이크 - 4,000원");
	}
	//음료 메뉴 선택
	public void selectDrinkMenu() {
		System.out.println("주문할 메뉴 번호 입력> ");
		int menu = scan.nextInt();
			
		}
	}
}
