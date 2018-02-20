package models;

import java.sql.Date;

public class Orders {
	private int id;
	private int customerId;
	private double totalCost;
	private Date orderDate;
	private String creditCardNumber;
	private String billingAddress;
//	• Validates billing address
//	• Ensures the desired ticket quantity will not exceed the showroom capacity 
	
	public Orders() {
		super();
	}

	public Orders(int id, int customerId, double totalCost, Date orderDate,
			String creditCardNumber, String billingAddress) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.creditCardNumber = creditCardNumber;
		this.billingAddress = billingAddress;
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
