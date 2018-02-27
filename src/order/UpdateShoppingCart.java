package order;

import java.io.IOException;
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
import models.Theatres;
import models.Orders;
import data.access.layer.MovieShowingDB;
import data.access.layer.MoviesDB;
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
		int movieId = (Integer) request.getAttribute("movieId");
		int theaterId = (Integer) request.getAttribute("theaterId");
		int showingId = (Integer) request.getAttribute("showingId");
		String type = (String) request.getAttribute("type");
		int quantity = (Integer) request.getAttribute("quantity");
		
		HttpSession session = request.getSession();
		List<HashMap> cart = (List<HashMap>) session.getAttribute("cart");
		
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(showingId);
		
		MoviesDB mdb = new MoviesDB();
		Movie movie = mdb.getMovie(movieId);
		
		TheatersDB tdb = new TheatersDB();
		Theatres theater = tdb.getTheater(theaterId);
		
		if(type.equals("add")){
			double price = quantity * showing.getPrice();
			
			Orders order = new Orders();
			if(order.checkValidQuantity(quantity)){
				HashMap cartItem = new HashMap(7);
				cartItem.put("movieId", movie.getId());
				cartItem.put("ticketQuantity", quantity);
				cartItem.put("movieName", movie.getTitle());
				cartItem.put("moviePoster", movie.getThumbnail());
				cartItem.put("theaterName", theater.getName());
				cartItem.put("showtime", showing.getStartTime());
				cartItem.put("price", price);
				
				cart.add(cartItem);
				
				session.setAttribute("cart", cart);
				
				int totalPrice = 0;
				for(Hashmap item: cart){
					totalPrice += item.get("price");
				}
				session.setAttribute("totalPrice", totalPrice);
			}			
		}
		else if(type.equals("delete")){
			int i=0;
			int price = 0;
			for(Hashmap item: cart){
				if(item.get("movieId") == movie.getId() && item.get("ticketQuantity") == quantity){
					price = item.get("price");
					cart.remove(i);
					break;
				}
				i++;
			}
			int totalPrice = (Integer) session.getAttribute("totalPrice");
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