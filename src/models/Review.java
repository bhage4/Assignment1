package models;

import java.sql.Date;

public class Review {
	private int id;
	private int movieId;
	private int userId;
	private Date reviewDate;
	private String rating;
	private String review;
	
	private static int maxReviewSize = 100;

	public Review(int id, int movieId, int userId, Date reviewDate,
			String rating, String review) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.userId = userId;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.review = review;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		if(review.length() <= maxReviewSize){
			this.review = review;
		}
	}
}
