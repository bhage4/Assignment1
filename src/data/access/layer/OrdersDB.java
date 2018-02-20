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
import models.Theatres;

public class OrdersDB {
	private Database db;
	private Statement stmt;
	private Connection conn;
	private PreparedStatement ps;
	
	public List<Orders> getAllOrders(){
		db = new Database();
		
		List<Orders> theaters = new ArrayList<Orders>();
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
				String address = rs.getInt("BillingAddress");
				String creditCardNumber = rs.getString("CreditCardNumber");
				
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
		try {
			conn = db.databaseConnect();

			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO orders (customerId, totalCost, OrderDate, BillingAddress, CreditCardNumber)"
				+" VALUES ('{0}', '{1}', '{2}', '{3}', '{4}')",
				order.getCustomerId(), order.getTotalCost(), order.getOrderDate().toString(), order.getBillingAddress(), order.getCreditCardNumber());
			
			stmt.executeUpdate(sql);
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateOrder(Orders order){
		String sql = "UPDATE orders SET customerId=?, totalCost=?, OrderDate=?, BillingAddress=?, CreditCardNumber=? WHERE id=?";
		try {
			conn = db.databaseConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, order.getCustomerId());
			ps.setString(2, order.getTotalCost());
			ps.setString(3, order.getOrderDate());
			ps.setString(4, order.getBillingAddress());
			ps.setString(5, order.getCreditCardNumber());
			
			ps.executeUpdate();
			db.closeConnection();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
