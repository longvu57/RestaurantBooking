package restaurantBooking.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SeatMapper implements RowMapper<Seat>{
	public Seat mapRow(ResultSet rs, int rowNum) throws SQLException{
		Seat seat = new Seat();
		seat.setId(rs.getInt("id"));
		seat.setMessage(rs.getString("message"));
		seat.setDate(rs.getString("date"));
		seat.setTime(rs.getString("time"));
		seat.setSeatName(rs.getString("seatName"));
		seat.setStatus(rs.getInt("status"));
		seat.setUserId(rs.getInt("userId"));
		return seat;
	}
}
