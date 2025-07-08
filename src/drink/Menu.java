package drink;

public class Menu {
	//Field
	int no;
	int price;
	String name;
	
	//Constructor
	public Menu() {
		
	}
	public Menu(int no, int price, String name) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	//Method
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}

}




















