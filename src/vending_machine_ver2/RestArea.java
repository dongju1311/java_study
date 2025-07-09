package vending_machine_ver2;

public class RestArea {
	//Field
	String name;
	User user;
	VendingMachine machine;
	//Constructor
	public RestArea () {
		this("용산");
	}
	public RestArea(String name) {
		this.name = name;
		user = new User();
		welcome();
		machine = new VendingMachine(user);
	}
	
	//Method
	public void welcome() {
		System.out.println("-----------------------------------");
		System.out.println("\t"+ name + " 봉숭아에 오신것을 환영합니다.");
		System.out.println("-----------------------------------");
	}
	

}
