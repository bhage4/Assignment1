package models;

public class Transactions {
	private CreditCard card;
	private double balance;
	
	public Transactions(CreditCard card, double balance) {
		super();
		this.card = card;
		this.balance = balance;
	}
	
	public CreditCard getCard() {
		return card;
	}
	public void setCard(CreditCard card) {
		this.card = card;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
