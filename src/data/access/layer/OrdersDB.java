package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Orders;

public class OrdersDB {
	private Database db;
	private Statement stmt;
	private Connection conn;
	private PreparedStatement ps;
	
	//TODO: test this class
	
	public List<Orders> getOrdersForUser(int userId){
		db = new Database();
		List<Orders> orders = new ArrayList<Orders>();
		
		String sql = "SELECT * FROM orders WHERE CustomerId=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			  
			ResultSet rs = ps.executeQuery();
				  
			while(rs.next()){
				int id = rs.getInt("id");
				double cost = rs.getInt("TotalCost");
				Date orderDate = null;//orderDate.valueOf(rs.getString("OrderDate"));
				String billingAddress = rs.getString("BillingAddress");
				int cardNum = rs.getInt("CreditCardNumber");
				
				Orders order = new Orders(id, userId, cost, orderDate, cardNum, billingAddress);
				orders.add(order);
			}
			
			rs.close();
			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public List<Orders> getAllOrders(){
		db = new Database();
		
		List<Orders> orders = new ArrayList<Orders>();
		String sql = "SELECT * FROM orders";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int customerId = rs.getInt("customerId");
				double cost = rs.getDouble("totalCost");
				Date orderDate = null;//orderDate.valueOf(rs.getString("OrderDate"));
				String address = rs.getString("BillingAddress");
				int creditCardNumber = rs.getInt("CreditCardNumber");
				
				Orders order = new Orders(id, customerId, cost, orderDate, creditCardNumber, address);
				orders.add(order);			
			}
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public void addOrder(Orders order){
		db = new Database();
		
		String sql = "INSERT INTO orders (customerId, totalCost, OrderDate, BillingAddress, CreditCardNumber) VALUES (?, ?, ?, ?, ?)";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getCustomerId());
			ps.setDouble(2, order.getTotalCost());
			ps.setDate(3, order.getOrderDate());
			ps.setString(4, order.getBillingAddress());
			ps.setInt(5, order.getCreditCardNumber());
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateOrder(Orders order){
		db = new Database();
		
		String sql = "UPDATE orders SET customerId=?, totalCost=?, OrderDate=?, BillingAddress=?, CreditCardNumber=? WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getCustomerId());
			ps.setDouble(2, order.getTotalCost());
			ps.setDate(3, order.getOrderDate());
			ps.setString(4, order.getBillingAddress());
			ps.setInt(5, order.getCreditCardNumber());
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
