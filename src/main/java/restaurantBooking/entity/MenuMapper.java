package restaurantBooking.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MenuMapper implements RowMapper<Menu>{
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException{
		Menu menu = new Menu();
		menu.setId(rs.getInt("id"));
		menu.setFoodName(rs.getString("foodName"));
		menu.setFoodPrice(rs.getDouble("foodPrice"));
		menu.setFoodDescription(rs.getString("foodDescription"));
		menu.setFoodType(rs.getInt("foodType"));
		menu.setImageUrl(rs.getString("imageUrl"));
		menu.setSubtitle(rs.getString("subtitle"));
		return menu;
	}
}
