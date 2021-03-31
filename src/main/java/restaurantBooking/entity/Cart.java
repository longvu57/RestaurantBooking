package restaurantBooking.entity;

public class Cart {
	private int quantity;
	private double subTotal;
	private Menu menu;

	public Cart() {
	}

	public Cart(int quantity, double subTotal, Menu menu) {
		super();
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.menu = menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
