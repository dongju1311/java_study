package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		//입출금 용지 한장 비치됨
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList();
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		
		BankMan staffPark = new BankMan("박보검", kbsystem); // 은행직원 생성시 고객리스트 정보 가짐
		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0);
		hong.setAccountpaper(accountPaper);
		
		//은행직원이 고객의 용지를 받는다
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.validateCheck(); // 고객에게 전달받은 출금용지에 빈값이 있는지 체크!
		staffPark.validateCheck(hong.answer(staffPark.checkResult));
		
	}

}
