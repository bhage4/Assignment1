package models;

import java.sql.Time;

public class MovieShowing {
	private int id;
	private int movieId;
	private int showroomId;
	private double price;
	private int numberPurchased;
	private Time startTime;
	private Time endTime;
	
	public MovieShowing(int id, int movieId, int showroomId, double price,
			int numberPurchased, Time startTime, Time endTime) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.showroomId = showroomId;
		this.price = price;
		this.numberPurchased = numberPurchased;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public int getShowroomId() {
		return showroomId;
	}
	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(int numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
}
