package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.MovieShowing;
import models.Theatres;

public class MovieShowingDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	public MovieShowing getShowing(int id){
		db = new Database();
		
		String sql = "SELECT * FROM movieShowing WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			double price = rs.getDouble("Price");
			int numberPurchased = rs.getInt("NumberPurchased");
			Time startTime = rs.getTime("StartTime");
			Time endTime = rs.getTime("EndTime");
			int movieId = rs.getInt("movieID");
			int showroomId = rs.getInt("showroomID");
			
			MovieShowing showing = new MovieShowing(id, movieId, showroomId, price, numberPurchased, startTime, endTime);

			db.closeConnection();
			rs.close();
			return showing;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<MovieShowing> getAllShowings(){
		db = new Database();
		
		List<MovieShowing> showings = new ArrayList<MovieShowing>();
		String sql = "SELECT * FROM movieShowing";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("Id");
				double price = rs.getDouble("Price");
				int numberPurchased = rs.getInt("NumberPurchased");
				Time startTime = rs.getTime("StartTime");
				Time endTime = rs.getTime("EndTime");
				int movieId = rs.getInt("movieID");
				int showroomId = rs.getInt("showroomID");
				
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
	
	public List<MovieShowing> searchShowings(HashMap parameters){
		String movieId = (String) parameters.get("movieId");
		String showRoomId = (String) parameters.get("showRoomId");
		
		List<MovieShowing> showings = new ArrayList<MovieShowing>();
		String sql = "SELECT * FROM movieShowing";
		
		int count=0;
		String[] terms = new String[2];

		if(movieId != null || showRoomId != null){
			sql += " WHERE";
		}
		if(movieId != null){
			sql += " movieId=?";
			count++;
			terms[count-1] = movieId;
		}
		if(showRoomId != null){
			if(count>0){
				sql += ",";
			}
			sql += " showroomID=?";
			count++;
			terms[count-1] = showRoomId;
		}
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			for(int i=1; i<=count; i++){
				ps.setString(i, terms[i-1]);
			}
			  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("Id");
				int price = rs.getInt("Price");
				int numPurchased = rs.getInt("NumberPurchased");
				Time startTime = rs.getTime("StartTime");
				Time endTime = rs.getTime("EndTime");
				int movieID = rs.getInt("movieID");
				int showRoomID = rs.getInt("showroomID");
				
				MovieShowing showing = new MovieShowing(id, movieID, showRoomID, price, numPurchased, startTime, endTime);
				showings.add(showing);
			}		
			
			db.closeConnection();
			rs.close();
			return showings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
