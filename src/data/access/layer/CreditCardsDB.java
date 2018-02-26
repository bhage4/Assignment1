package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.CreditCard;

public class CreditCardsDB {
	private Database db;
	private Statement stmt;
	private Connection conn;
	
	public void addCard(CreditCard aCard){
		db = new Database();
		
		try {
			conn = db.databaseConnect();

			//stmt = conn.createStatement();
			
			String sql = "INSERT INTO creditcards (CardHolderName, CreditCardNumber, CardType, UserId, CVV, ExpirationDate)"
				+" VALUES (?, ?, ?, (SELECT users.Id from users where Id = ?), ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aCard.getCardHolderName());
			ps.setInt(2, aCard.getCardNumber());
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
	
	public CreditCard getCard(int cardNumber){
		
		return null;
	}
	
	public List<CreditCard> searchCards(String parameters){
		return null;
	}
}
