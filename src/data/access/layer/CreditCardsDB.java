package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

			stmt = conn.createStatement();
			
			String sql = String.format("INSERT INTO creditcards (CardHolderName, CreditCardNumber, Balance, CardType, UserId, CCV, ExpirationDate)"
				+" VALUES ('{0}', '{1}', '{2}', '{3}', '{4}', '{5}', '{6}'')",
				aCard.getCardHolderName(), aCard.getCardNumber(), aCard.getBalance(), aCard.getCardType(), aCard.getUserId(), aCard.getCcv(), aCard.getExpirationDate());
			
			stmt.executeUpdate(sql);
			db.closeConnection();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<CreditCard> searchCards(String parameters){
		return null;
	}
}
