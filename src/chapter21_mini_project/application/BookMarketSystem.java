package chapter21_mini_project.application;

import java.util.Scanner;

import chapter21_mini_project.Service.BookMarketServiceImpl;

public class BookMarketSystem {
	public static final int MEMBER_INFO = 1;
	public static final int CART_LIST = 2;
	public static final int CART_CLEAR = 3;
	public static final int CART_ADD = 4;
	public static final int CART_DELETE_ITEM = 5;
	public static final int PRINT_BILL = 6;
	public static final int EXIT = 7;
	public Scanner scan;
	public BookMarketServiceImpl service;
	
	public BookMarketSystem() {
		scan = new Scanner(System.in);
		service = new BookMarketServiceImpl(this);
		createMember();
		showMenu();
		
	}
	/**
	 * 회원정보 등록
	 */
	public void createMember() {
		System.out.println("회원등록을 하시고 쇼핑을 진행해 주세요.");
		service.menuGuestAdd();
	}
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		String [] labels = {"1. 고객정보 확인하기",
							"2. 장바구니 상품 목록 보기",
							"3. 장바구니 비우기",
							"4. 장바구니 항목 추가하기",
							"5. 장바구니 항목 삭제하기",
							"6. 영수증 출력하기",
							"7. 종료"
		};
		System.out.println("******************************************************************");
		System.out.println("\tWelcome to Shopping Mall ");
		System.out.println("\tWelcome to Book Market!! ");
		System.out.println("******************************************************************");
		for(int i=0;i<labels.length;  i += 2) {
            System.out.print("  "+labels[i]);

            if (i + 1 < labels.length) {
            	if (i + 2 == 2) {
                    System.out.print("\t\t" + labels[i + 1]);
                } else if(i + 2 == 4 ) {
                    System.out.print("\t\t\t" + labels[i + 1]);
                } else {
                	System.out.print("\t" + labels[i + 1]);                	
                }
            }

            System.out.println();
		}		
		System.out.println("******************************************************************");
		
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴(숫자)> ");
		if(scan.hasNextInt()) {	
			switch(scan.nextInt()) {
				case MEMBER_INFO:		service.menuGuestInfo();		break;
				case CART_LIST:			service.menuCartItemList();			break;
				case CART_CLEAR: 		service.menuCartClear();		break;
				case CART_ADD:			service.menuCartAddItem();		break;
				case CART_DELETE_ITEM:	service.menuCartRemoveItem();		break;
				case PRINT_BILL:		service.menuCartBill();		break;
				case EXIT:				service.menuExit();			break;
				default:	
					System.out.println("=> 메뉴 준비중 입니다.");
					selectMenu();
			}			
		} else {
			System.out.println("🚫 올바르지 않은 형식입니다. 다시 선택해주세요");
			scan.next();
			selectMenu();
		}
	}
	

public static void main(String[] args) {
	new BookMarketSystem();
}	
		
		
}
