package kbank2;

public class BankMan {
	//Field
	String name;
	int checkResult;
	private AccountPaperVo accountPaper;
	private AccountVo[] accountList;
	private BankSystem kbsystem;
	
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;
	
	//Constructor
	public BankMan() {
		
	}
	public BankMan(String name, BankSystem kbsystem) {
		this.name = "[은행 직원 : " +name +"]";
		this.kbsystem = kbsystem;
		System.out.println(this.name + "업무 시작!!");
	}
	//Method
	/**
	 * 고객의 출금정보 유효성 체크 결과에 따라 질문
	 */
	public void ask(int status) {
		switch(status) {
		case ACCOUNT_NAME:
			System.out.println(this.name + "이름을 입력해 주세요");
			checkResult = ACCOUNT_NAME;
			break;
		case ACCOUNT_NUMBER:
			System.out.println(this.name + "계좌번호를 입력해 주세요");
			checkResult = ACCOUNT_NUMBER;
			break;
		case ACCOUNT_PASSWORD:
			System.out.println(this.name + "패스워드를 입력해 주세요");
			checkResult = ACCOUNT_PASSWORD;
			break;
		case ACCOUNT_MONEY:
			System.out.println(this.name + "금액을 입력해 주세요");
			checkResult = ACCOUNT_MONEY;
			break;
	}
		
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크!!
	 */
	public void validateCheck() {
		System.out.println(this.name + "고객 정보에 대한 유효성 체크를 진행한다.");
		
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크!!
	 */
	public void validateCheck(AccountPaperVo updateAccountPaper) {
		System.out.println(this.name + "고객 정보에 대한 유효성 체크를 진행한다.");
		this.accountPaper = updateAccountPaper;
		
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			
		}
	}
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(this.name + " 손님에게 출금용지 받음!");
	}
	public AccountVo[] getAccountList() {
		return accountList;
	}
	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}
	public BankSystem getKbsystem() {
		return kbsystem;
	}
	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}
	
	

}
