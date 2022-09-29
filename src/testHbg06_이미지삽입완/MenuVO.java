package testHbg06_이미지삽입완;

public class MenuVO {
	
	private String menu;
	private int price;
	
	@Override
	public String toString() {
		return "메뉴: " + menu + "\t\t" + "가격: " + price + "원\n";
	}
	
	public MenuVO () {}
	
	public MenuVO (String menu, int price) {
		super();
		this.menu = menu;
		this.price = price;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	

}
