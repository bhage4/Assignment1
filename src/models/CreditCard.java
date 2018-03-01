package models;

import java.sql.Date;

import data.access.layer.CreditCardsDB;

public class CreditCard {
	
	private int id;
	private String cardHolderName;
	private String cardNumber;
	private String cardType;
	private int userId;
	private String ccv;
	private Date expirationDate;	//(int year, int month, int day)

	public CreditCard() {
		super();
	}
	public CreditCard(int id, String cardHolderName, String cardNumber,
			String cardType, int userId, String ccv,
			Date expirationDate) {
		super();
		this.id = id;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.userId = userId;
		this.ccv = ccv;
		this.expirationDate = expirationDate;
	}
	
	public CreditCard(String cardHolderName, String cardNumber, String cardType,
			int userId, String ccv, Date expirationDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.userId = userId;
		this.ccv = ccv;
		this.expirationDate = expirationDate;
	}
	public boolean validateCreditCardInfo(double price, double balance, CreditCard card){
		int cardLength = String.valueOf(this.cardNumber).length();
		if(cardLength > 19 || cardLength < 13){
			return false;
		}
		
		int ccvLength = String.valueOf(this.ccv).length();
		if(ccvLength != 3){
			return false;
		}
		
		if(!card.getCardHolderName().equalsIgnoreCase(this.cardHolderName)){
			return false;
		}
		if(!card.getCardType().equalsIgnoreCase(this.cardType)){
			return false;
		}
		if(!card.getCcv().equals(this.ccv)){
			return false;
		}
		if(!card.getExpirationDate().equals(this.expirationDate)){
			return false;
		}
		if(balance<price){
			return false;
		}
		return true;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
