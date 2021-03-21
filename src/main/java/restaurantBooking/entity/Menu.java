package restaurantBooking.entity;

public class Menu {
	private int id;
	private String foodName;
	private double foodPrice;
	private String foodDescription;
	private int foodType;
	private String imageUrl;
	private String subtitle;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int id, String foodName, double foodPrice, String foodDescription, int foodType, String imageUrl,
			String subtitle) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodDescription = foodDescription;
		this.foodType = foodType;
		this.imageUrl = imageUrl;
		this.subtitle = subtitle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public int getFoodType() {
		return foodType;
	}
	public void setFoodType(int foodType) {
		this.foodType = foodType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
}
