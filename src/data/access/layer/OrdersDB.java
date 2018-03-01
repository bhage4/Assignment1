package data.access.layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Orders;

public class OrdersDB {
	private Database db;
	private Connection conn;
	private PreparedStatement ps;
	
	//TODO: test this class
	
	public Orders getOrder(int id){
		db = new Database();
		
		String sql = "SELECT * FROM orders WHERE Id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			
			int customerId = rs.getInt("CustomerId");
			double cost = rs.getDouble("TotalCost");
			Date orderDate = Date.valueOf(rs.getString("OrderDate"));
			String address = rs.getString("BillingAddress");
			String creditCardNumber = rs.getString("CreditCardNumber");
			
			List<HashMap> orderItems = new ArrayList<HashMap>();
			
			rs.close();
			
			//Get order items
			sql = "SELECT * FROM orderitems WHERE OrderId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				int itemId = rs.getInt("Id");
				int showingId = rs.getInt("ShowingId");
				int quantity = rs.getInt("Quantity");
				
				HashMap map = new HashMap(3);
				map.put("itemId", itemId);
				map.put("showingId", showingId);
				map.put("quantity", quantity);
				
				orderItems.add(map);
			}
						
			Orders order = new Orders(id, customerId, cost, orderDate, creditCardNumber, address, orderItems);

			db.closeConnection();
			rs.close();
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
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
				int id = rs.getInt("Id");
				double cost = rs.getInt("TotalCost");
				Date orderDate = Date.valueOf(rs.getString("OrderDate"));
				String billingAddress = rs.getString("BillingAddress");
				String cardNum = rs.getString("CreditCardNumber");
				
				List<HashMap> orderItems = new ArrayList<HashMap>();
				
				Orders order = new Orders(id, userId, cost, orderDate, cardNum, billingAddress, orderItems);
				
				orders.add(order);
			}
			
			rs.close();
			
			for(Orders order: orders){
				//Get order items
				sql = "SELECT * FROM orderitems WHERE OrderId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, order.getId());
				
				rs = ps.executeQuery();
				List<HashMap> items = order.getOrderItems();
				
				while(rs.next()){
					int itemId = rs.getInt("Id");
					int showingId = rs.getInt("ShowingId");
					int quantity = rs.getInt("Quantity");
					
					HashMap map = new HashMap(3);
					map.put("itemId", itemId);
					map.put("showingId", showingId);
					map.put("quantity", quantity);
					
					items.add(map);
				}
				order.setOrderItems(items);
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
				Date orderDate = Date.valueOf(rs.getString("OrderDate"));
				String address = rs.getString("BillingAddress");
				String creditCardNumber = rs.getString("CreditCardNumber");
				
				List<HashMap> orderItems = new ArrayList<HashMap>();
				
				Orders order = new Orders(id, customerId, cost, orderDate, creditCardNumber, address, orderItems);
				
				orders.add(order);
			}
			
			rs.close();
			
			for(Orders order: orders){
				//Get order items
				sql = "SELECT * FROM orderitems WHERE OrderId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, order.getId());
				
				rs = ps.executeQuery();
				List<HashMap> items = order.getOrderItems();
				
				while(rs.next()){
					int itemId = rs.getInt("Id");
					int showingId = rs.getInt("ShowingId");
					int quantity = rs.getInt("Quantity");
					
					HashMap map = new HashMap(3);
					map.put("itemId", itemId);
					map.put("showingId", showingId);
					map.put("quantity", quantity);
					
					items.add(map);
				}
				order.setOrderItems(items);
			}
			db.closeConnection();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public int addOrder(Orders order){
		db = new Database();
		String sql = "INSERT INTO orders (CustomerId, TotalCost, OrderDate, BillingAddress, CreditCardNumber) VALUES ((SELECT Id from users where users.Id = ?), ?, ?, ?, ?)";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getCustomerId());
			ps.setDouble(2, order.getTotalCost());
			ps.setDate(3, order.getOrderDate());
			ps.setString(4, order.getBillingAddress());
			ps.setString(5, order.getCreditCardNumber());
			
			ps.executeUpdate();
			
			sql = "SELECT LAST_INSERT_ID()";
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			int orderId = rs.getInt(1);
			
			sql = "INSERT INTO orderitems (OrderId, ShowingId, Quantity) VALUES (?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			for(HashMap map: order.getOrderItems()){
				ps.setInt(2, (Integer) map.get("showingId"));
				ps.setInt(3, (Integer) map.get("quantity"));
				
				ps.executeUpdate();
			}
			
			rs.close();
			db.closeConnection();
			return orderId;
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public void updateOrder(Orders order){
		db = new Database();
		
		String sql = "UPDATE orders SET CustomerId=?, TotalCost=?, OrderDate=?, BillingAddress=?, CreditCardNumber=? WHERE Id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getCustomerId());
			ps.setDouble(2, order.getTotalCost());
			ps.setDate(3, order.getOrderDate());
			ps.setString(4, order.getBillingAddress());
			ps.setString(5, order.getCreditCardNumber());
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void deleteOrder(int id){
		db = new Database();
		
		String sql = "DELETE FROM orders WHERE Id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteOrderItem(int id){
		db = new Database();
		
		String sql = "DELETE FROM orderitems WHERE Id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}