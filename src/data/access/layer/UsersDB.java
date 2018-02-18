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
		conn = db.databaseConnect();
		
		try {
			stmt = conn.createStatement();
			String sql;
		
			sql = String.format("INSERT INTO Users (FirstName, LastName, Address, City, State, PostalCode, EmailAddress, PhoneNumber, Birthday, Type, Status, NumOfVisits, Username, Password)"
				+" VALUES ('{0}', '{1}', '{2}', '{3}', '{4}', '{5}', '{6}', '{7}', '{8}', '{9}', '{10}', '{11}', '{12}')",
				user.getFirstName(), user.getLastName(), user.getAddress(), user.getCity(), user.getState(), user.getPostalCode(), user.getEmail(), user.getPhoneNumber(), user.getBirthday().toString(),
				user.getUserType(), user.getStatus(), user.getNumOfVisits(), user.getUserName(), user.getPassword());
			stmt.executeUpdate(sql);
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		db.closeConnection();
	}
	
	public Users getUserByUsername(String username){
		String sql = "SELECT * FROM users where Username=?";
		try {
			ps = conn.prepareStatement(sql);
	
			ps.setString(1, username);
			  
			ResultSet rs = ps.executeQuery();
				  
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String state = rs.getString("State");
			int postalCode = rs.getInt("PostalCode");
			String emailAddress = rs.getString("EmailAddress");
			int phoneNumber = rs.getInt("PhoneNumber");
			Date birthday = java.sql.Date.valueOf(rs.getString("Birthday"));	//Does this work for Bethany
			String type = rs.getString("Type");
			String status = rs.getString("Status");
			int numOfVisits = rs.getInt("NumOfVisits");
			String password = rs.getString("Password");
			
			Users user = new Users(username, password, firstName, lastName, address, city, state, postalCode, emailAddress, phoneNumber, birthday, type, status, numOfVisits);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
	
	public boolean checkIfExists(String username){
		return false;
	}
	
	public boolean validatePassword(String password){
		return false;
	}
	
	public String checkUserType(String username){
		return null;
	}
}
