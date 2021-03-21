package restaurantBooking.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seat {
	private int id;
	private String message;
	Date rawDate = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String date = formatter.format(rawDate);
	SimpleDateFormat localDate = new SimpleDateFormat("HH:mm");
	private String time = localDate.format(new Date());

	private String seatName;
	private int status;
	private int userId;
	List<User> users;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int id, String message, Date rawDate, SimpleDateFormat formatter, String date,
			SimpleDateFormat localDate, String time, String seatName, int status, int userId) {
		super();
		this.id = id;
		this.message = message;
		this.rawDate = rawDate;
		this.formatter = formatter;
		this.date = date;
		this.localDate = localDate;
		this.time = time;
		this.seatName = seatName;
		this.status = status;
		this.userId = userId;
	}

	public Seat(int id, String message, String date, String time, String seatName, int status) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
		this.time = time;
		this.seatName = seatName;
		this.status = status;
	}

	public List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<>();
		}
		return users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getRawDate() {
		return rawDate;
	}

	public void setRawDate(Date rawDate) {
		this.rawDate = rawDate;
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SimpleDateFormat getLocalDate() {
		return localDate;
	}

	public void setLocalDate(SimpleDateFormat localDate) {
		this.localDate = localDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
