//package restaurantBooking.entity;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//
//public class SeatMapExtractor implements ResultSetExtractor<Map<Integer, List<String>>>{
//	@Override
//	public List<Seat> extractData(ResultSet rs) throws SQLException, DataAccessException{
//		HashMap<Integer, Seat> seats = new HashMap<>();
//		while(rs.next()) {
//			int seatId = rs.getInt("id");
//			String message = rs.getString("message");
//			String date = rs.getString("date");
//			String time = rs.getString("time");
//			String seatName = rs.getString("seatName");
//			
//			String username = rs.getString("username");
//			String phone = rs.getString("phone");
//		}   
//		return new ArrayList<Seat>(seats.values());
//	}
//}
