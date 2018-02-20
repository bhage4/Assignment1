package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import models.MovieShowing;

public class MovieShowingDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	public List<MovieShowing> getAllShowings(){
		db = new Database();
		
		List<MovieShowing> showings = new ArrayList<MovieShowing>();
		String sql = "SELECT * FROM movieShowing";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				double price = rs.getDouble("price");
				int numberPurchased = rs.getInt("numberPurchased");
				Time startTime = rs.getTime("StartTime");
				Time endTime = rs.getTime("EndTime");
				int movieId = rs.getInt("movieId");
				int showroomId = rs.getInt("showroomId");
				
				MovieShowing showing = new MovieShowing(id, movieId, showroomId, price, numberPurchased, startTime, endTime);
				showings.add(showing);			
			}
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showings;
	}
	
	public List<MovieShowing> searchShowings(String parameter){
		return null;
	}
}
