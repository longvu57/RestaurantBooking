package restaurantBooking.entity;

public class OrderDetail {
	private String foodName;
	private double foodPrice;
	private int quantity;
	private double subTotal;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String foodName, double foodPrice, int quantity, double subTotal) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
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

}
