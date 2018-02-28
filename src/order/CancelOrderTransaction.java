package order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import data.access.layer.MovieShowingDB;
import data.access.layer.OrdersDB;
import data.access.layer.CreditCardsDB;
import models.MovieShowing;
import models.Transactions;
import models.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CancelOrderTransaction")
public class CancelOrderTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CancelOrderTransaction() {
        super();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		HttpSession session = request.getSession();
		List<HashMap> cart = (List<HashMap>) session.getAttribute("cart");
		
		int i=0;
		for(HashMap item: cart){
			if(item.get("order").equals(orderId)){
				cart.remove(i);
				break;
			}
			i++;
		}
		OrdersDB odb = new OrdersDB();
		Orders order = odb.getOrder(orderId);
		
		CreditCardsDB ccdb = new CreditCardsDB();
		Transactions transaction = ccdb.getTransaction(order.getCreditCardNumber());
		
		double newBalance = order.getTotalCost() + transaction.getBalance();
		transaction.setBalance(newBalance);
		ccdb.updateBalance(transaction);
		
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(order.getShowingId());
		
		int newQuantity = order.getTicketsOrdered() + showing.getNumberPurchased();
		showing.setNumberPurchased(newQuantity);
		msdb.updatePurchased(showing);
		//should this be a redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancellationConfirmation.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}