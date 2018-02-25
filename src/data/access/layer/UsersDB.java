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
	
	public void addUser(Users aUser) {
		db = new Database();
		
		try {
		  conn = db.databaseConnect();
		  stmt = conn.createStatement();
		  String sql;
		  
		  String firstName = aUser.getFirstName();
		  if(firstName != null)
			  firstName = "'" + firstName + "'";
		  String lastName = aUser.getLastName();
		  if(lastName != null)
			  lastName = "'" + lastName + "'";
		  String address = aUser.getAddress();
		  if(address != null)
			  address = "'" + address + "'";
		  String city = aUser.getCity();
		  if(city != null)
			  city = "'" + city + "'";
		  String state = aUser.getState();
		  if(state != null)
			  state = "'" + state + "'";
		  int postalCode = aUser.getPostalCode();
		  String email = aUser.getEmail();
		  if(email != null)
			  email = "'" + email + "'";
		  int phone = aUser.getPhoneNumber();
		  Date birthday = aUser.getBirthday();
		  String type = aUser.getUserType();
		  if(type != null)
			  type = "'" + type + "'";
		  String status = aUser.getStatus();
		  if(status != null)
			  status = "'" + status + "'";
		  int numVisits = aUser.getNumOfVisits();
		  String userName = aUser.getUserName();
		  if(userName != null)
			  userName = "'" + userName + "'";
		  String password = aUser.getPassword();
		  if(password != null)
			  password = "'" + password + "'";

		  sql = "INSERT INTO users (FirstName, LastName, Address, City, State, PostalCode, EmailAddress, PhoneNumber, Birthday, Type, Status, NumOfVisits, Username, Password)" +
		          "VALUES (" + firstName +
				  ", " + lastName + 
				  ", " + address + 
				  ", " + city + 
				  ", " + state + 
				  ", " + postalCode + 
				  ", " + email +
				  ", " + phone +
				  ", " + birthday +
				  ", " + type +
				  ", " + status + 
				  ", " + numVisits +
				  ", " + userName +
				  ", " + password + 
				  ")";
		  stmt.executeUpdate(sql);
		  
		  db.closeConnection();
		  		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public Users getUser(String aUserName) {
		db = new Database();
		
		String SQL = "SELECT * from users";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			conn = db.databaseConnect();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString(14) )) {
					aUser.setFirstName(rs.getString(2));
					aUser.setLastName(rs.getString(3));
					aUser.setAddress(rs.getString(4));
					aUser.setCity(rs.getString(5));
					aUser.setState(rs.getString(6));
					aUser.setPostalCode(rs.getInt(7));
					aUser.setEmail(rs.getString(8));
					aUser.setPhoneNumber(rs.getInt(9));
					aUser.setBirthday(rs.getDate(10));
					aUser.setUserType(rs.getString(11));
					aUser.setStatus(rs.getString(12));
					aUser.setNumOfVisits(rs.getInt(13));
					aUser.setUserName(rs.getString(14));
					aUser.setPassword(rs.getString(15));
					
				} 
		    }
			
		    stat.close();
		    rs.close();
		    db.closeConnection();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	
	public Users getUser(int id) {
		db = new Database();
		
		String SQL = "SELECT * from users";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(id == rs.getInt(1)) {
					aUser.setFirstName(rs.getString(2));
					aUser.setLastName(rs.getString(3));
					aUser.setAddress(rs.getString(4));
					aUser.setCity(rs.getString(5));
					aUser.setState(rs.getString(6));
					aUser.setPostalCode(rs.getInt(7));
					aUser.setEmail(rs.getString(8));
					aUser.setPhoneNumber(rs.getInt(9));
					aUser.setBirthday(rs.getDate(10));
					aUser.setUserType(rs.getString(11));
					aUser.setStatus(rs.getString(12));
					aUser.setNumOfVisits(rs.getInt(13));
					aUser.setUserName(rs.getString(14));
					aUser.setPassword(rs.getString(15));
					
				} 
		    }
			
		    stat.close();
		    rs.close();
		    db.closeConnection();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	
	public boolean checkIfExists(String aUserName) {
		db = new Database();
		
		boolean userExists = false;
		String SQL = "SELECT * from users";
	    Statement stat;
		try {
			conn = db.databaseConnect();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(aUserName.equals( rs.getString(14) )) {
					userExists = true;
				}    
		    }
			
		    stat.close();
		    rs.close();
		    db.closeConnection();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userExists;
	}
	
	public boolean validatePassword(String username, String password) {
		db = new Database();
		
		boolean passwordMatches = false;
		String SQL = "SELECT * from users";
	    Statement stat;
		try {
			conn = db.databaseConnect();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(username.equals(rs.getString(14)) && password.equals( rs.getString(15) )) {
					passwordMatches = true;
				}    
		    }
			
		    stat.close();
		    rs.close();
		    db.closeConnection();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return passwordMatches;
	}

	
	public void displayAllUsers() {
		db = new Database();
		
		String SQL = "SELECT * from users";
	    Statement stat;
		try {
			conn = db.databaseConnect();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
		        System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3)
		        		+ " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)
		        		+ " " + rs.getString(8) + " " + rs.getString(9) + " " + rs.getString(10) + " " + rs.getString(11)
		        		+ " " + rs.getString(12) + " " + rs.getString(13) + " " + rs.getString(14)+ " " + rs.getString(15));
		    }
			
		    stat.close();
		    rs.close();
		    db.closeConnection();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
