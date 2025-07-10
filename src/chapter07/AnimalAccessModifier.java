package chapter07;

public class AnimalAccessModifier {
	//Field
	String name; //같은 패키지에서만 접근 가능
	int age; //같은 패키지에서만 접근 가능
	

	private String pname; //같은 클래스 내부에서만 접근 가능
	private int page; //같은 클래스 내부에서만 접근 가능
	
	static String sname; //static 변수, 클래스 변수
	static int sage;
	
	
	//Constructor
	public AnimalAccessModifier () {
		
	}
	public AnimalAccessModifier (String pname, int page) {
		this.pname = pname;
		this.page = page;
	}
	
	//static method
	void getInfo() {System.out.println((pname + "," + page));}; // 같은 패키지안에서만 호출이 가능
	public void getInfo2() {System.out.println((pname + "," + page));}; // 모든 클래스에서 호출이 가능
	static public void getInfo3() {System.out.println((sname + ", " + sage));}; 
	
	
	//getter/setter
	public String getPname() {return pname;}
	public int getPage() {return page;}
	
	public void setPname(String pname) { this.pname = pname; }
	public void setPname(int page) { this.page = page; }
	
}
