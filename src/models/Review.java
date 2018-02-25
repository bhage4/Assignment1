package models;

import java.sql.Date;
import models.Users;

public class Review {
	private int id;
	private int movieId;
	private Users user;
	private Date reviewDate;
	private String rating;
	private String review;
	
	private static int maxReviewSize = 100;

	public Review() {
		super();
	}
	public Review(int id, int movieId, Users user, Date reviewDate,
			String rating, String review) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.user = user;
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
