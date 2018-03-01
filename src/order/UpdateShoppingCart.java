package order;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Movie;
import models.MovieShowing;
import models.Orders;
import models.Showroom;
import models.Theatres;
import data.access.layer.MovieShowingDB;
import data.access.layer.MoviesDB;
import data.access.layer.OrdersDB;
import data.access.layer.TheatersDB;

@WebServlet("/UpdateShoppingCart")
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateShoppingCart() {
        super();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int movieId = Integer.parseInt(request.getParameter("movieId"));	
		String type = request.getParameter("type");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		List<HashMap> cart = (List<HashMap>) session.getAttribute("cart");
		if(cart == null){
			cart = new ArrayList<HashMap>();
		}
		
		MoviesDB mdb = new MoviesDB();
		Movie movie = mdb.getMovie(movieId);
		
		if(type.equals("add")){
			int theaterId = Integer.parseInt(request.getParameter("theaterId"));
			int showingId = Integer.parseInt(request.getParameter("showingId"));
			
			MovieShowingDB msdb = new MovieShowingDB();
			MovieShowing showing = msdb.getShowing(showingId);
			
			TheatersDB tdb = new TheatersDB();
			Theatres theater = tdb.getTheater(theaterId);
			Showroom room = tdb.getShowroom(showing.getShowroomId());
			
			double price = quantity * showing.getPrice();
			String theaterNameNum = theater.getName() + " " + room.getRoomNumber();
			
			Orders order = new Orders();	//This never actually adds anything to order?
			if(order.checkValidQuantity(quantity, showingId)){
				HashMap cartItem = new HashMap(9);
				cartItem.put("orderId", order.getId());
				cartItem.put("movieId", movie.getId());
				cartItem.put("ticketQuantity", quantity);
				cartItem.put("movieName", movie.getTitle());
				cartItem.put("moviePoster", movie.getThumbnail());
				cartItem.put("theaterNameNum", theaterNameNum);
				cartItem.put("showtime", showing.getStartTime());
				cartItem.put("price", price);
				cartItem.put("showingId", showing.getId());
				
				cart.add(cartItem);
				
				OrdersDB odb = new OrdersDB();
				odb.addOrder(order);
				
				session.setAttribute("cart", cart);
				
				double totalPrice = 0;
				for(HashMap item: cart){
					totalPrice += (Double) item.get("price");
				}
				session.setAttribute("totalPrice", totalPrice);
			}			
		}
		else if(type.equals("delete")){
			int i=0;
			double price = 0;
			for(HashMap item: cart){
				if((Integer)item.get("movieId") == movie.getId() && (Integer) item.get("ticketQuantity") == quantity){
					price = (Double) item.get("price");
					cart.remove(i);
					break;
				}
				i++;
			}
			double totalPrice = (Double) session.getAttribute("totalPrice");
			totalPrice -= price;
			
			session.setAttribute("totalPrice", totalPrice);
			session.setAttribute("cart", cart);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAndCheckoutShoppingCart.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}