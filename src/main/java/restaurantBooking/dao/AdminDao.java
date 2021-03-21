package restaurantBooking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import restaurantBooking.entity.Menu;
import restaurantBooking.entity.Seat;
import restaurantBooking.entity.SeatMapper;
import restaurantBooking.entity.User;

@Repository
public class AdminDao {
	@Autowired
	JdbcTemplate template;

	public int addNewFood(Menu menu) {
		String sql = "INSERT INTO foods(foodName, foodPrice, foodDescription, foodType, imageUrl, subtitle) VALUES (?,?,?,?,?,?)";
		return template.update(sql, menu.getFoodName(), menu.getFoodPrice(), menu.getFoodDescription(),
				menu.getFoodType(), menu.getImageUrl(), menu.getSubtitle());
	}

	public int removeFoodById(int id) {
		String sql = "DELETE FROM foods WHERE id = " + id;
		return template.update(sql);
	}

	public int updateFood(Menu menu) {
		String sql = "UPDATE foods SET foodName = '" + menu.getFoodName() + "', foodPrice = " + menu.getFoodPrice()
				+ ", foodDescription = '" + menu.getFoodDescription() + "', foodType=" + menu.getFoodType()
				+ ", imageUrl = '" + menu.getImageUrl() + "', subtitle='" + menu.getSubtitle() + "' WHERE id="
				+ menu.getId();
		return template.update(sql);
	}

	public List<Seat> getAllSeats() {
		List<Seat> seatsWithUsers = new ArrayList<Seat>();
		String sql = "SELECT users.username, users.phone, users.email, seats.id, seats.message, seats.date, seats.time, seats.seatName, seats.status\r\n"
				+ "FROM users\r\n" + "RIGHT JOIN seats\r\n" + "ON users.id = seats.userId\r\n" + "ORDER BY users.id";
		seatsWithUsers = template.query(sql, new ResultSetExtractor<List<Seat>>() {

			@Override
			public List<Seat> extractData(ResultSet rs) throws SQLException, DataAccessException {
				HashMap<Integer, Seat> seats = new HashMap<>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String message = rs.getString("message");
					String date = rs.getString("date");
					String time = rs.getString("time");
					String seatName = rs.getString("seatName");
					int status = rs.getInt("status");
					Seat s = seats.get(id);
					if (s == null) {
						s = new Seat(id, message, date, time, seatName, status);
						seats.put(id, s);
					}

					String username = rs.getString("username");
					String phone = rs.getString("phone");
					User user = new User(username, phone);
					s.getUsers().add(user);
				}
				return new ArrayList<Seat>(seats.values());
			}
		});
		return seatsWithUsers;
	}
	
	public int accepTable(int id) {
		String sql = "UPDATE seats SET status = 2 WHERE id = " +id;
		return template.update(sql);
	}
	
	public int finishTable(int id) {
		String sql = "UPDATE seats SET status = 0 WHERE id = " +id;
		return template.update(sql);
	}

}
