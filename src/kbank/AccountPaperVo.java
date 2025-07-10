package kbank;


public class AccountPaperVo {
	//Field
	private String name;
	private int accountNo;
	private int money;
	private int password;
	
	//Constructor
	public AccountPaperVo () {
		
	}
	public AccountPaperVo (String name, int accountNo, int money, int password) {
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
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}

}
