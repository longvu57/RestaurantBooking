package restaurantBooking.entity;

public class Item {
	private Menu menu;
	private int quantity;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Menu menu, int quantity) {
		super();
		this.menu = menu;
		this.quantity = quantity;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
