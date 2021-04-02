package restaurantBooking.entity;

public class Order {
	private int id;
	private String userName;
	private String phone;
	private String address;
	private String content;
	private double totalMoney;
	private int status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String userName, String phone, String address, String content, double totalMoney, int status) {
		super();
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.content = content;
		this.totalMoney = totalMoney;
		this.status = status;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
