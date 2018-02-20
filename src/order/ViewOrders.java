package order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Orders;

import data.access.layer.OrdersDB;

@WebServlet("/ViewOrders")
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewOrders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = 0;
		OrdersDB odb = new OrdersDB();
		List<Orders> ordersForUser = odb.getOrdersForUser(id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
//	This servlet uses the session information (of the customer) to find all the orders
//	for the customer.
//	o It fetches the customer’s orders using the OrdersDB and redirects the user to the
//	View Orders jsp page with the results

}
