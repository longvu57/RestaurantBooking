package restaurantBooking.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import restaurantBooking.entity.Menu;
import restaurantBooking.entity.MenuMapper;
import restaurantBooking.entity.Seat;
import restaurantBooking.entity.SeatMapper;
import restaurantBooking.entity.User;
import restaurantBooking.entity.UserMapper;

@Repository
public class HomeDao {
	@Autowired
	JdbcTemplate template;

	public List<Menu> getAllMenu() {
		List<Menu> menu = new ArrayList<Menu>();
		String sql = "SELECT * FROM foods";
		menu = template.query(sql, new MenuMapper());
		return menu;
	}

	public int register(User user) {
		User existUser = findByUser(user.getUsername());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());

		if (existUser == null) {
			String role = "ROLE_USER";
			int enabled = 1;
			String sql = "INSERT INTO users(username, password, phone, email, role, enabled) VALUES(?,?,?,?,?,?)";
			return template.update(sql, user.getUsername(), hashedPassword, user.getPhone(), user.getEmail(), role,
					enabled);
		} else {
			return 0;
		}

	}

	public User findByUser(String username) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users WHERE username = '" + username + "'";
		users = template.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	public Menu findFoodById(int id) {
		List<Menu> menu = new ArrayList<Menu>();
		String sql = "SELECT* FROM foods WHERE id= " + id;
		menu = template.query(sql, new MenuMapper());
		return menu.size() > 0 ? menu.get(0) : null;
	}

	public Seat existSeat(Seat seat) {
		String sql = "SELECT * FROM seats WHERE date = '" + seat.getDate() + "'"
				+ " AND DATE_FORMAT(time, '%H' '%i') = '" + seat.getTime() + "' AND status = 1";
		List<Seat> seats = new ArrayList<Seat>();
		seats = template.query(sql, new SeatMapper());
		return seats.size() > 0 ? seats.get(0) : null;
	}

	public int findIdByName(String name) {
		User user = new User();
		int id;
		String sql = "SELECT * FROM users WHERE username=" + "'" + name + "'";
		List<User> users = new ArrayList<User>();
		users = template.query(sql, new UserMapper());
		if (users != null) {
			user = users.get(0);
			id = user.getId();
			return id;
		} else {
			return (Integer) null;
		}
	}
	public List<String> getEmptySeats(){
		List<String> seatNames = new ArrayList<String>();
		List<Seat> seats = new ArrayList<Seat>();
		String sql = "SELECT * FROM seats WHERE status = 0";
		seats = template.query(sql, new SeatMapper());
		for(int i = 0; i < seats.size(); i++) {
			seatNames.add(seats.get(i).getSeatName());
		}
		return seatNames;
	}
	
	public int addSeat(Seat seat) {
		String sql = "UPDATE seats SET message = ?,date = ?, time=?, status=1, userId = ? WHERE seatName = ?";
		return template.update(sql, seat.getMessage(), seat.getDate(), seat.getTime(), seat.getUserId(), seat.getSeatName());
	}
}
