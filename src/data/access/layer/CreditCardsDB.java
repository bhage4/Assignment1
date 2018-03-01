package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.CreditCard;
import models.Transactions;

public class CreditCardsDB {
	private Database db;
	private PreparedStatement ps;
	private Connection conn;
	
	public void addCard(CreditCard aCard){
		db = new Database();
		
		try {
			conn = db.databaseConnect();			
			String sql = "INSERT INTO creditcards (CardHolderName, CreditCardNumber, CardType, UserId, CVV, ExpirationDate)"
				+" VALUES (?, ?, ?, (SELECT users.Id from users where Id = ?), ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aCard.getCardHolderName());
			ps.setString(2, aCard.getCardNumber());
			ps.setString(3, aCard.getCardType());
			ps.setInt(4, aCard.getUserId());
			ps.setString(5, aCard.getCcv());
			ps.setDate(6, aCard.getExpirationDate());
			
			ps.executeUpdate();
							
			//stmt.executeUpdate(sql);
			db.closeConnection();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public CreditCard getCard(String cardNumber){
		db = new Database();
		
		String sql = "SELECT * FROM creditcards WHERE CreditCardNumber=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardNumber);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.first();
				  
			int id = rs.getInt("Id");
			String name = rs.getString("CardHolderName");
			String type = rs.getString("CardType");
			int userId = rs.getInt("UserId");
			String cvv = rs.getString("CVV");
			Date expDate = rs.getDate("ExpirationDate");
			
			CreditCard card = new CreditCard(id, name, cardNumber, type, userId, cvv, expDate);
			
			rs.close();
			db.closeConnection();
			return card;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public CreditCard getCard(int userId){
		db = new Database();
		
		String sql = "SELECT * FROM creditcards WHERE UserId=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.first();
				  
			int id = rs.getInt("Id");
			String name = rs.getString("CardHolderName");
			String type = rs.getString("CardType");
			String cardNumber = rs.getString("CreditCardNumber");
			String cvv = rs.getString("CVV");
			Date expDate = rs.getDate("ExpirationDate");
			
			CreditCard card = new CreditCard(id, name, cardNumber, type, userId, cvv, expDate);
			
			rs.close();
			db.closeConnection();
			return card;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Transactions getTransaction(int userId){
		db = new Database();
		
		String sql = "SELECT * FROM creditcards WHERE UserId=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			
			rs.first();
				  
			int id = rs.getInt("Id");
			String name = rs.getString("CardHolderName");
			String type = rs.getString("CardType");
			String cardNumber = rs.getString("CreditCardNumber");
			String cvv = rs.getString("CVV");
			Date expDate = rs.getDate("ExpirationDate");
			int balance = rs.getInt("Balance");
			
			CreditCard card = new CreditCard(id, name, cardNumber, type, userId, cvv, expDate);
			Transactions transaction = new Transactions(card, balance);
			
			rs.close();
			db.closeConnection();
			return transaction;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CreditCard> searchCards(String parameters){
		return null;
	}
	
	public void updateBalance(Transactions transaction){
		db = new Database();
		
		String sql = "UPDATE creditcards SET Balance=? WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, transaction.getBalance());
			ps.setInt(2, transaction.getCard().getId());
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
