package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	//Field
	String[] nameList = {"오리 감자탕", "미나리새우전","숙성 모듬회", "돼지곱창전골"};
	int[] priceList = {500,300,400,200};
	Menu[] menuList;
	Menu[] orderMenuList;
	int orderMenuCount = 0;
	
	User user; //자판기 사용자
	String title;//자판기 회사명
	int totalCoin;
	Menu orderMenu;
	int change;
	
	//Constructor
	public VendingMachine(User user) {
		this("용산 봉숭아",user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	//Method
	
	//메뉴 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0;i<nameList.length;i++) {
			int no = i+1;
			int price = priceList[i];
			String name = nameList[i];
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
			
		}
			
	}
	//구매가능 메뉴 출력
	public void showMenuList(String msg) {
		System.out.println("-----------------------------------");
		System.out.println("\t"+ title + "\t Menu");
		System.out.println("-----------------------------------");
		System.out.println("\t" + msg);
		System.out.println("-----------------------------------");
		for(int i=0;i<orderMenuCount;i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo()+ ".\t");
			System.out.print(menu.getName()+ "\t\t");
			System.out.print(String.format("%,d", menu.getPrice())+ "원\n");
		}
		System.out.println("-----------------------------------");
	}
	//메뉴리스트 출력
	public void showMenuList() {
		System.out.println("-----------------------------------");
		System.out.println("\t"+ title + "\t Menu");
		System.out.println("-----------------------------------");
		for(Menu menu:menuList) {
			System.out.print(menu.getNo()+ ".\t");
			System.out.print(menu.getName()+ "\t\t");
			System.out.print(String.format("%,d", menu.getPrice())+ "원\n");
		}
		System.out.println("-----------------------------------");
	}
	
	//구매가능 메뉴 리스트 생성
	
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
	}
	
	//메뉴 체크
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		for(int i=0;i<orderMenuCount;i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) result = true;
		}
		return result;
	}
	//종료 후 객체 초기화
	public void init() {
		orderMenuCount = 0;
		orderMenuList = null;
		orderMenu = null;
		totalCoin = 0;
	}
	
	//코인 체크
	public void checkInsertCoin() {
		System.out.println("=>동전을 투입해주세요~");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입 금액 : " + totalCoin);
			if(totalCoin<200) {
				System.out.println("=> 최소금액부족");
				checkInsertCoin();
			} else {
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키)> ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();
				} else {
				checkInsertCoin();
				}
		}
			} else {
			System.out.println("=> 동전은 100원, 500원만 사용가능합니다.");
			checkInsertCoin();
		}
	}
	//메뉴 선택
	public void selectMenu() {
		System.out.println("=> 메뉴를 선택해 주세요");
		System.out.println("=> 취소는 9번을 입력해 주세요");
		int menuNo = user.selectMenu();
			if(menuNo != 9) {
				if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			} else {
				selectMenu();
			} 
	} else {
			System.out.println("****************************");
			System.out.println("동전을 반환하고 프로그램을 종료합니다.");
			System.out.println("반환 동전 : " + totalCoin);
			System.exit(0);
	}
}
	//주문
	public void placeOrder(int menuNo) {
		for(Menu menu:orderMenuList) {
			if(menu != null) {
				if(menu.getNo()==menuNo) orderMenu=menu;
			} else break;
		}
		System.out.println("=> 주문완료!!");
		System.out.println("=> 음료제조중");
		processPayment();
	}
	//결제
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(orderMenu.getPrice() <= totalCoin) {
				change = totalCoin-price;
				System.out.println("결제 완료!!");
				init();
			}
		}
		finalCheck();
	}
	//파이널 체크
	public void finalCheck() {
		int price = menuList[menuList.length-1].getPrice();
		if(change >= price) {
			totalCoin = change;
			System.out.print("잔돈 : " + change);
			createOrderMenuList(totalCoin);
			showMenuList("주문 가능 메뉴 리스트");
			selectMenu();
		} else {
			System.out.println("=> 결제 내역!!");
			System.out.println("잔돈 : " + change);
			System.out.println("=> 이용해 주셔서 감사합니다!!");
		}
	}
}
