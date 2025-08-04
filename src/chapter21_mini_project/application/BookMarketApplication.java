package chapter21_mini_project.application;

import java.util.Scanner;

import chapter21_mini_project.Service.BookService;
import chapter21_mini_project.Service.Service;

public class BookMarketApplication {

	public Scanner scan;
	public Service service;
	
	public BookMarketApplication() {
		this.scan = new Scanner(System.in);
		this.service = new BookService(this);
	}
	/**
	 * 이름 및 번호 입력
	 */
	
	public void insertInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("당신의 이름을 입력해 주세요 : ");
		String name = scan.next();
		
		System.out.print("연락처를 입력하세요 : ");
		String phone = scan.next();
	}
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		String[] labels = {"고객 정보 확인하기", "장바구니 상품 목록 보기", "장바구니 비우기", "바구니에 항목 추가하기", "장바구니의 항목 수량 줄이기", "장바구니 항목 삭제하기", "영수증 표시하기", "종료"};
		System.out.println("**************************************************************");
		System.out.println("\t\t Welcome to Shopping Mall");
		System.out.println("\t\t Welcome to BookMarket!");
		System.out.println("**************************************************************");
		for(int i=0;i<labels.length ;i++) {
			System.out.println((i+1)+". "+labels[i]);
		}
		System.out.println("**************************************************************");
		selectMenu();
	}
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴 번호를 선택해 주세요. ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				service.menuGuestInfo();
				break;
			case 2:
				service.menuCartItemList();
				break;
			case 3:
				service.menuCartClear();
				break;
			case 4:
				service.menuCartAddItem();
				break;
			case 5: 
				service.menuCartRemoveItemCount();
				break;
			case 6 :
				service.menuCartRemoveItem();
				break;
			case 7:
				service.menuCartBill();
				break;
			case 8:
				service.menuExit();
				break;
			default:
				System.out.println("=> 메뉴 준비중 입니다.");
				selectMenu();
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해 주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	
	public static void main(String[] args) {
		
		BookMarketApplication market = new BookMarketApplication();
		market.insertInfo();
		market.showMenu();

	}

}
