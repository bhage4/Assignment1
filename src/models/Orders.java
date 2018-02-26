package models;

import java.sql.Date;
import models.Users;
import data.access.layer.MovieShowingDB;
import data.access.layer.TheatersDB;
import data.access.layer.UsersDB;

public class Orders {
	private int id;
	private int customerId;
	private int showingId;
	private int ticketsOrdered;
	private double totalCost;
	private Date orderDate;
	private int creditCardNumber;
	private String billingAddress;
	
	public Orders() {
		super();
	}

	public Orders(int id, int customerId, int showingId, int ticketsOrdered, double totalCost, Date orderDate,
			int creditCardNumber, String billingAddress) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.showingId = showingId;
		this.ticketsOrdered = ticketsOrdered;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.creditCardNumber = creditCardNumber;
		this.billingAddress = billingAddress;
	}
	
	public boolean checkValidAddress(int userId){
		UsersDB udb = new UsersDB();
		Users user = udb.getUser(userId);
		
		if(user.getAddress() != this.billingAddress){
			return false;
		}
		return true;
	}
	
	public boolean checkValidQuantity(int quantity){
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(this.showingId);
		int numPurchased = showing.getNumberPurchased();
		
		TheatersDB tdb = new TheatersDB();
		Showroom room = tdb.getShowroom(showing.getShowroomId());
		int capacity = room.getAvailableSeats();
		
		int remainingSeats = capacity - numPurchased;
		if(remainingSeats - quantity >= 0){
			return true;
		}
		else{
			return false;
		}		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getShowingId() {
		return showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}

	public int getTicketsOrdered() {
		return ticketsOrdered;
	}

	public void setTicketsOrdered(int ticketsOrdered) {
		this.ticketsOrdered = ticketsOrdered;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
