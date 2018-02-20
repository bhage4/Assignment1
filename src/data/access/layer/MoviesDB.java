package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Movie;

public class MoviesDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	public Movie getMovieDetails(String title){
		db = new Database();
		
		String sql = "SELECT * FROM movies WHERE MovieName=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			  
			ResultSet rs = ps.executeQuery();
				  
			int id = rs.getInt("id");
			String description = rs.getString("description");
			String thumbnail = rs.getString("thumbnail");
			String rating = rs.getString("rating");
			
			Movie movie = new Movie(id, title, description, thumbnail, rating);
			
			rs.close();
			db.closeConnection();
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Movie getMovieDetails(int id){
		db = new Database();
		
		String sql = "SELECT * FROM movies WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			  
			ResultSet rs = ps.executeQuery();
				  
			String title = rs.getString("title");
			String description = rs.getString("description");
			String thumbnail = rs.getString("thumbnail");
			String rating = rs.getString("rating");
			
			Movie movie = new Movie(id, title, description, thumbnail, rating);
			
			rs.close();
			db.closeConnection();
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Movie> searchMovies(String parameter){	//Not really sure how to set this up for now... Maybe use hashmap for search terms?
		return null;
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
				String title = rs.getString("title");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				String rating = rs.getString("rating");
				
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
