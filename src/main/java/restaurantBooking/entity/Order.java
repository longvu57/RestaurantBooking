package restaurantBooking.entity;

public class Order {
	private int id;
	private String userName;
	private String phone;
	private String address;
	private double totalMoney;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String userName, String phone, String address, double totalMoney) {
		super();
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.totalMoney = totalMoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}
