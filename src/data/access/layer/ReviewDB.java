package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Review;
import models.Theatres;

public class ReviewDB {
	private Database db;
	private Statement stmt;
	private Connection conn;
	private PreparedStatement ps;
	
	public void addReview(Review aReview){
		db = new Database();
		try {
			conn = db.databaseConnect();

			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO customerreviews (movieId, userId, ReviewDate, Rating, Review)"
				+" VALUES ('{0}', '{1}', '{2}', '{3}', '{4}')",
				aReview.getMovieId(), aReview.getUserId(), aReview.getReviewDate().toString(), aReview.getRating(), aReview.getReview());
			
			stmt.executeUpdate(sql);
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Review> getReviews(int movieId){
		db = new Database();
		
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * FROM customerreviews WHERE movieId=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Date reviewDate = Date.valueOf(rs.getString("ReviewDate"));
				String rating = rs.getString("Rating");
				String review = rs.getString("Review");
				int userId = rs.getInt("userId");
				int reviewId = rs.getString("id");
				
				Review review = new Review(reviewId, movieId, userId, reviewDate, rating, review);
				reviews.add(review);			
			}
			rs.close();
			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
}
