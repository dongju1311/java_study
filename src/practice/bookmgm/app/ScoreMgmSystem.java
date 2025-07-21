package practice.bookmgm.app;

import java.util.Scanner;

import practice.bookmgm.service.ScoreService;

public class ScoreMgmSystem {
	public Scanner scan;
	ScoreService service;
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	public ScoreMgmSystem() {
		
	}
	
	public int getCount() {
		return service.getCount();
	}
	
	public void selectMenu() {
		System.out.print("메뉴(숫자)선택> ");
		if(scan.hasNextInt()) {
		int menu = scan.nextInt();
			switch(menu) {
			case REGISTER:
				service.list();
				break;
			case LIST:
				service.list();
				break;
			case SEARCH:
				service.search();
				break;
			case UPDATE:
				service.update();
				break;
			case DELETE:
				service.delete();
				break;
			case EXIT:
				service.exit();
				break;
			default:
				System.out.println("=> 메뉴 준비중 입니다.");
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
}
