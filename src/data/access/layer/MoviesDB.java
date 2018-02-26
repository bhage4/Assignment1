package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.Movie;
import models.MovieShowing;

public class MoviesDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	public Movie getMovie(String title){
		db = new Database();
		
		String sql = "SELECT * FROM movies WHERE MovieName=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.first();
				  
			int id = rs.getInt("id");
			String description = rs.getString("Description");
			String thumbnail = rs.getString("Thumbnail");
			String rating = rs.getString("Rating");
			
			Movie movie = new Movie(id, title, description, thumbnail, rating);
			
			rs.close();
			db.closeConnection();
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Movie getMovie(int id){
		db = new Database();
		
		String sql = "SELECT * FROM movies WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.first();
				  
			String title = rs.getString("MovieName");
			String description = rs.getString("Description");
			String thumbnail = rs.getString("Thumbnail");
			String rating = rs.getString("Rating");
			
			Movie movie = new Movie(id, title, description, thumbnail, rating);
			
			rs.close();
			db.closeConnection();
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Movie> searchMovies(HashMap parameters){ //untested by Bethany
		String name = (String) parameters.get("name");
		String rating = (String) parameters.get("rating");
		
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "SELECT * FROM movies";
		
		int count=0;
		String[] terms = new String[2];

		if(name != null || rating != null){
			sql += " WHERE";
		}
		if(name != null){
			sql += " name=?";
			count++;
			terms[count-1] = name;
		}
		if(rating != null){
			if(count>0){
				sql += ",";
			}
			sql += " rating=?";
			count++;
			terms[count-1] = rating;
		}
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			for(int i=1; i<=count; i++){
				ps.setString(i, terms[i-1]);
			}
			  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String thisName = rs.getString("MovieName");
				String description = rs.getString("Description");
				String thumbnail = rs.getString("Thumbnail");
				String thisRating = rs.getString("Rating");
				
				Movie movie = new Movie(id, thisName, description, thumbnail, rating);
				movies.add(movie);			
			}	
			
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public List<Movie> getAllMovies(){
		db = new Database();
		
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "SELECT * FROM movies";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("MovieName");
				String description = rs.getString("Description");
				String thumbnail = rs.getString("Thumbnail");
				String rating = rs.getString("Rating");
				
				Movie movie = new Movie(id, title, description, thumbnail, rating);
				movies.add(movie);			
			}
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
}
