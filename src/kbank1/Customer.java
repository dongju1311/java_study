package kbank1;

import java.util.Scanner;

public class Customer {
	//Field
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accoountpaper;
	private Scanner scan;
	
	//Constructor
	public Customer() {
		
	}
	public Customer(String name, String accountNumber, String password, int money) {
		scan = new Scanner(System.in);
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
	}
	
	//Method
	public Scanner getScan() {
		return scan;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public AccountPaperVo getAccoountpaper() {
		return accoountpaper;
	}
	public void setAccoountpaper(AccountPaperVo accoountpaper) { //은행 비치용 입출금용지 가져옴
		this.accoountpaper = accoountpaper;
		this.accoountpaper.setName(this.name);
		this.accoountpaper.setAccountNumber(this.accountNumber);
		this.accoountpaper.setPassword(this.password);
		this.accoountpaper.setMoney(this.money);
	}
	
	
}
