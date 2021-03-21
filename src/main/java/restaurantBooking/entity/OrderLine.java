package restaurantBooking.entity;

public class OrderLine {
	private int id;
	private int orderId;
	private Menu menu;
	private int quantity;
	private double unitPrice;
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLine(int id, int orderId, Menu menu, int quantity, double unitPrice) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.menu = menu;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public OrderLine(Menu menu, int quantity) {
		super();
		this.menu = menu;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
