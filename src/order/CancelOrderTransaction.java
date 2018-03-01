package order;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.access.layer.MovieShowingDB;
import data.access.layer.MoviesDB;
import data.access.layer.OrdersDB;
import data.access.layer.CreditCardsDB;
import models.Movie;
import models.MovieShowing;
import models.Transactions;
import models.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		OrdersDB odb = new OrdersDB();
		Orders order = odb.getOrder(orderId);
		
		CreditCardsDB ccdb = new CreditCardsDB();
		Transactions transaction = ccdb.getTransaction(order.getCreditCardNumber());
		
		double newBalance = order.getTotalCost() + transaction.getBalance();
		transaction.setBalance(newBalance);
		ccdb.updateBalance(transaction);
		
		MovieShowingDB msdb = new MovieShowingDB();
		
		List<HashMap> cancelOrder = new ArrayList<HashMap>();
		
		for(HashMap item: order.getOrderItems()){
			HashMap map = new HashMap(3);
			
			MovieShowing showing = msdb.getShowing((Integer) item.get("showingId"));
			MoviesDB mdb = new MoviesDB();
			Movie movie = mdb.getMovie(showing.getMovieId());
			
			double price = (Integer) item.get("quantity") * showing.getPrice();
			
			
			if(showing.getStartTime().after(new Timestamp(System.currentTimeMillis()))){
				int ticketsOrdered = 0;
				ticketsOrdered = (Integer) item.get("quantity");
				
				int newQuantity = ticketsOrdered + showing.getNumberPurchased();
				showing.setNumberPurchased(newQuantity);
				msdb.updatePurchased(showing);
				
				request.setAttribute("refundStatus", "Yes");
			}
			else{
				request.setAttribute("refundStatus", "No");
			}
			
			map.put("movieName", movie.getTitle());
			map.put("quantity", (Integer) item.get("quantity"));
			map.put("price", price);
			
			cancelOrder.add(map);
		}
		
		request.setAttribute("result", cancelOrder);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancellationConfirmation.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}