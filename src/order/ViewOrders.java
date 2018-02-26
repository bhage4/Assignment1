package order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Orders;
import models.Users;

import data.access.layer.OrdersDB;

@WebServlet("/ViewOrders")
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewOrders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		int id = user.getId();
		OrdersDB odb = new OrdersDB();
		List<Orders> ordersForUser = odb.getOrdersForUser(id);
		
		request.setAttribute("ordersForUser", ordersForUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOrders.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}