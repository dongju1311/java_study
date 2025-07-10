package kbank;

public class AccountVo {
	//Field
	private String name;
	private int accountNo;
	private int money;
	private int password;
	
	//Constructor
	public AccountVo() {
		
	}
	
	public AccountVo(String name, int accountNo, int money, int password) {
		this.name = name;
		this.accountNo = accountNo;
		this.money = money;
		this.password = password;
	}
	
	//Method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoney() {
		return money;
	}
	public void setAmount(int money) {
		this.money = money;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	
}
