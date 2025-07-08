package lunch;

public class LunchOrderMenuManager {
	//Field
	String[] lunchMenuNames= {"햄버거(🍔)","피자요(🍕) ","라멘요(🍜)","샐러드(🥗)"};
	int[] lunchMenuPrice= {100,200,300,400};
	LunchOrderSystemOOP system;
	//Constructor
	public LunchOrderMenuManager() { }
	public LunchOrderMenuManager(LunchOrderSystemOOP system) { 
		this.system = system;
	}
		/*
		 * 런치메뉴 생성
		 */
		public void createLunchMenu() {
			LunchMenu menu = null;
			for(int i=0;i<system.lunchMenuNames.length;i++) {
				menu = new LunchMenu();
				menu.no = i+1;
				menu.name = lunchMenuNames[i];
				menu.price = lunchMenuPrice[i];
				system.lunchMenuList[i] = menu;
			}
			}
		/*
		 * 런치메뉴 출력
		 */
		public void showLunchMenu () {
			System.out.println("**************************************");
			for(LunchMenu menu:system.lunchMenuList) {
				System.out.print(menu.no + ". ");
				System.out.print(menu.name + "\t");
				System.out.print(menu.price + "\n");
		}
			System.out.println("**************************************");
		}
		/*
		 * 런치메뉴 선택
		 */
		public void selectLunchMenu() {
			System.out.print("주문메뉴(숫자) > ");
			
			if(system.scan.hasNextInt()) {
				lunchMenuCheck(system.scan.nextInt());
			} else {
				System.out.println("=> 입력된 값이 바르지 않습니다. 다시 입력!!");
				system.scan.next();
				selectLunchMenu();
		}
		}
			
		/*
		 * 메인메뉴 출력
		 */
		public void showMainMenu() {
			System.out.println("**************************************");
			System.out.println("\tWelcome to ["+system.title+"]Food Market");
			System.out.println("**************************************");
			System.out.println("\t 1. 음식 주문");
			System.out.println("\t 2. 주문 내역");
			System.out.println("\t 3. 음식 결제");
			System.out.println("\t 4. 결제 내역");
			System.out.println("\t 9. 프로그램종료");
			System.out.println("**************************************");
			System.out.println("******Food mart에 오신것을 환영합니다.******");
//			createLunchMenu();
			selectMainMenu();
		}//showMainMenu method
		/*
		 * 메인메뉴 선택
		 */
		public void selectMainMenu() {
			System.out.print("메인메뉴(숫자) > ");
			
			if(system.scan.hasNextInt()) {
				mainMenuCheck(system.scan.nextInt());
			} else {
				System.out.println("=> 입력된 값이 바르지 않습니다. 다시 입력!!");
				system.scan.next();
				selectMainMenu();
			}
		}
	     /*
	      * 메인메뉴 체크
	      */
			public void mainMenuCheck(int mainMenu) {
				switch(mainMenu) {
				case 1: showLunchMenu();
						selectLunchMenu();
				break;
				case 2: system.orderList();
				break;
				case 3: system.payment();
				break;
				case 4: system.paymentList();
				break;
				case 9:
					System.out.println("=> 음식 주문 시스템 종료");
					System.exit(0);
				break;
				default : 
					System.out.println("=> 메뉴 준비중");
					showMainMenu();
				}
			}
			/*
			 * 런치메뉴 체크
			 */
			public void lunchMenuCheck(int lunchMenu) {
				if(1<=lunchMenu && lunchMenu<=4) {
					system.order(lunchMenu);
				} else {
					System.out.println("=> 런치 메뉴 준비중~");
					showLunchMenu();
			}
		}//mainMenuCheck
	}

