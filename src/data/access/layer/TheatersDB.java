package data.access.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import data.access.layer.Database;
import models.Theatres;
import models.Showroom;

public class TheatersDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	public Theatres getTheater(String name){
		db = new Database();
		
		String sql = "SELECT * FROM theatreBuildings WHERE Name=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			  
			ResultSet rs = ps.executeQuery();
				
			int id = rs.getInt("id");
			String address = rs.getString("address");
			int owner = rs.getInt("ownerId");
			String city = rs.getString("city");
			String state = rs.getString("state");
			int zip = rs.getInt("postalCode");
			
			Theatres theater = new Theatres(id, name, address, city, state, zip, owner);
			
			db.closeConnection();
			rs.close();
			return theater;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Theatres getTheater(int id){
		db = new Database();
		
		String sql = "SELECT * FROM theatreBuildings WHERE Id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			  
			ResultSet rs = ps.executeQuery();
				
			String name = rs.getString("name");
			String address = rs.getString("address");
			int owner = rs.getInt("ownerId");
			String city = rs.getString("city");
			String state = rs.getString("state");
			int zip = rs.getInt("postalCode");
			
			Theatres theater = new Theatres(id, name, address, city, state, zip, owner);
			
			db.closeConnection();
			rs.close();
			return theater;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Theatres> searchTheaters(HashMap parameters){
		String name = (String) parameters.get("name");
		
		List<Theatres> theaters = new ArrayList<Theatres>();
		String sql = "SELECT * FROM theatreBuildings WHERE name=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String address = rs.getString("address");
				int owner = rs.getInt("ownerId");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("postalCode");
				
				Theatres theater = new Theatres(id, name, address, city, state, zip, owner);
				theaters.add(theater);
			}		
			
			db.closeConnection();
			rs.close();
			return theaters;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Theatres> getAllTheaters(){
		db = new Database();
		
		List<Theatres> theaters = new ArrayList<Theatres>();
		String sql = "SELECT * FROM theatreBuildings";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				int id = rs.getInt("id");
				String address = rs.getString("address");
				int owner = rs.getInt("ownerId");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("postalCode");
				
				Theatres theater = new Theatres(id, name, address, city, state, zip, owner);
				theaters.add(theater);			
			}
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theaters;
	}
	
	public Showroom getShowroom(int theaterId){
		db = new Database();
		
		String sql = "SELECT * FROM Showrooms WHERE theatreBuilding=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, theaterId);
			  
			ResultSet rs = ps.executeQuery();
				
			int id = rs.getInt("Id");
			int seats = rs.getInt("availableSeats");
			int roomNumber = rs.getInt("roomNumber");
			
			Showroom room = new Showroom(id, seats, roomNumber, theaterId);
			
			db.closeConnection();
			rs.close();
			return room;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
