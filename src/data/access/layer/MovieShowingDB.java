package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.MovieShowing;
import models.Theatres;
import java.sql.Timestamp;

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
			
			rs.first();
			
			double price = rs.getDouble("Price");
			int numberPurchased = rs.getInt("NumberPurchased");
			Timestamp startTime = rs.getTimestamp("StartTime");
			Timestamp endTime = rs.getTimestamp("EndTime");
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
		db = new Database();
		String movieId = String.valueOf(parameters.get("movieId"));
		String showRoomId = String.valueOf(parameters.get("showRoomId"));
		Date date = (Date) (parameters.get("date"));
		
		List<MovieShowing> showings = new ArrayList<MovieShowing>();
		String sql = "SELECT * FROM movieShowing";
		
		int count=0;
		String[] terms = new String[3];

		if(movieId != null || showRoomId != null || date != null){
			sql += " WHERE";
		}
		if(movieId != null){
			sql += " movieId=?";
			count++;
			terms[count-1] = movieId;
		}
		if(showRoomId != null){
			if(count>0){
				sql += "and";
			}
			sql += " showroomID=?";
			count++;
			terms[count-1] = showRoomId;
		}
		if(date != null){
			if(count>0){
				sql += "and";
			}
			sql += " StartTime like ?";
			count++;
			terms[count-1] = "%" + date.toString() + "%";
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
