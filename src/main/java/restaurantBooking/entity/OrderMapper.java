package restaurantBooking.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order>{
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException{
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setUserName(rs.getString("username"));
		order.setAddress(rs.getString("address"));
		order.setPhone(rs.getString("phone"));
		order.setStatus(rs.getInt("status"));
		order.setContent(rs.getString("content"));
		order.setTotalMoney(rs.getDouble("totalMoney"));
		return order;
	}
}
