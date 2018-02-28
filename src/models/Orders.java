package models;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import data.access.layer.MovieShowingDB;
import data.access.layer.TheatersDB;
import data.access.layer.UsersDB;

@SuppressWarnings("rawtypes")
public class Orders {
	private int id;
	private int customerId;
	private List<HashMap> orderItems;	//Stores itemId, showingId, and ticketsOrdered
	private double totalCost;
	private Date orderDate;
	private int creditCardNumber;
	private String billingAddress;
	
	public Orders() {
		super();
	}

	public Orders(int customerId, double totalCost, Date orderDate, String billingAddress, List<HashMap> orderItems) {
		super();
		this.customerId = customerId;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.orderItems = orderItems;
		this.billingAddress = billingAddress;
	}

	public Orders(int id, int customerId, double totalCost, Date orderDate,
			int creditCardNumber, String billingAddress, List<HashMap> orderItems) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.creditCardNumber = creditCardNumber;
		this.billingAddress = billingAddress;
		this.orderItems = orderItems;
	}
	
	public boolean checkValidAddress(int userId){
		UsersDB udb = new UsersDB();
		Users user = udb.getUser(userId);
		
		if(user.getAddress() != this.billingAddress){
			return false;
		}
		return true;
	}
	
	public boolean checkValidQuantity(int quantity, int showingId){
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(showingId);
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

	public List<HashMap> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<HashMap> orderItems) {
		this.orderItems = orderItems;
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
