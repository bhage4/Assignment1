package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Users;

public class UsersDB {
	private Database db;
	private Statement stmt;
	private Connection conn;
	private PreparedStatement ps;
	
	public void addUser(Users user){
		db = new Database();
		
		try {
			conn = db.databaseConnect();

			stmt = conn.createStatement();
			
			String sql = String.format("INSERT INTO Users (FirstName, LastName, Address, City, State, PostalCode, EmailAddress, PhoneNumber, Birthday, Type, Status, NumOfVisits, Username, Password)"
				+" VALUES ('{0}', '{1}', '{2}', '{3}', '{4}', '{5}', '{6}', '{7}', '{8}', '{9}', '{10}', '{11}', '{12}')",
				user.getFirstName(), user.getLastName(), user.getAddress(), user.getCity(), user.getState(), user.getPostalCode(), user.getEmail(), user.getPhoneNumber(), user.getBirthday().toString(),
				user.getUserType(), user.getStatus(), user.getNumOfVisits(), user.getUserName(), user.getPassword());
			
			stmt.executeUpdate(sql);
			db.closeConnection();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Users getUser(String username){
		db = new Database();
		
		String sql = "SELECT * FROM users WHERE Username=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			  
			ResultSet rs = ps.executeQuery();
				  
			int id = rs.getInt("Id");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String state = rs.getString("State");
			int postalCode = rs.getInt("PostalCode");
			String emailAddress = rs.getString("EmailAddress");
			int phoneNumber = rs.getInt("PhoneNumber");
			Date birthday = Date.valueOf(rs.getString("Birthday"));	//Does this work for Bethany
			String type = rs.getString("Type");
			String status = rs.getString("Status");
			int numOfVisits = rs.getInt("NumOfVisits");
			String password = rs.getString("Password");
			
			Users user = new Users(id, username, password, firstName, lastName, address, city, state, postalCode, emailAddress, phoneNumber, birthday, type, status, numOfVisits);
			
			rs.close();
			db.closeConnection();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Users getUser(int id){
		db = new Database();
		
		String sql = "SELECT * FROM users WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			  
			ResultSet rs = ps.executeQuery();
				 
			String username = rs.getString("Username");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String state = rs.getString("State");
			int postalCode = rs.getInt("PostalCode");
			String emailAddress = rs.getString("EmailAddress");
			int phoneNumber = rs.getInt("PhoneNumber");
			Date birthday = Date.valueOf(rs.getString("Birthday"));	//Does this work for Bethany
			String type = rs.getString("Type");
			String status = rs.getString("Status");
			int numOfVisits = rs.getInt("NumOfVisits");
			String password = rs.getString("Password");
			
			Users user = new Users(id, username, password, firstName, lastName, address, city, state, postalCode, emailAddress, phoneNumber, birthday, type, status, numOfVisits);
			
			rs.close();
			db.closeConnection();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkIfExists(String username){
		db = new Database();
		
		String sql = "SELECT COUNT(*) FROM users WHERE Username=?";	
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			  
			ResultSet rs = ps.executeQuery();

			rs.close();
			db.closeConnection();
			return !rs.equals(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean validatePassword(String password, String username){
		db = new Database();
		
		String sql = "SELECT password FROM users WHERE Username=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			db.closeConnection();
			return rs.equals(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String checkUserType(String username){
		db = new Database();
		
		String sql = "SELECT type FROM users WHERE Username=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			  
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			db.closeConnection();
			return rs.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
