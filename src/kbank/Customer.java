package kbank;

import java.util.Scanner;

public class Customer {
	//Field
	Scanner scan;
	AccountPaperVo apv;
	
	//Constructor
	public Customer() {
		apv = new AccountPaperVo();
	}
	
	//Method
	public AccountPaperVo writePaper() {
		scan = new Scanner(System.in);
		System.out.println("고객명을 입력합니다.");
		System.out.print("이름입력 > ");
		String name = scan.next();
		
		System.out.println("계좌번호를 입력합니다");
		System.out.print("계좌번호 입력 > ");
		int accountNo = scan.nextInt();
		
		System.out.println("인출할 금액을 입력합니다");
		System.out.print("인출금액 입력 > ");
		int money = scan.nextInt();
		
		System.out.println("계좌비밀번호를 입력합니다");
		System.out.print("계좌비밀번호 입력 > ");
		int password = scan.nextInt();
		
		apv.setName(name);
		apv.setAccountNo(accountNo);
		apv.setMoney(money);
		apv.setPassword(password);
		
		return apv;
		
	}
	
}
	
