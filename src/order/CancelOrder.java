package order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Movie;
import models.MovieShowing;
import models.Orders;
import models.Showroom;
import models.Theatres;
import data.access.layer.MovieShowingDB;
import data.access.layer.MoviesDB;
import data.access.layer.OrdersDB;
import data.access.layer.TheatersDB;

@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancelOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		OrdersDB odb = new OrdersDB();
		Orders order = odb.getOrder(orderId);
		
		List<HashMap> itemInfo = new ArrayList<HashMap>();
		
		for(HashMap item: order.getOrderItems()){
			HashMap map = new HashMap(5);
			
			MovieShowingDB msdb = new MovieShowingDB();
			MovieShowing showing = msdb.getShowing((Integer) item.get("showingId"));
			
			MoviesDB mdb = new MoviesDB();
			Movie movie = mdb.getMovie(showing.getMovieId());
			
			TheatersDB tdb = new TheatersDB();
			Showroom room = tdb.getShowroom(showing.getShowroomId());
			Theatres theater = tdb.getTheater(room.getTheaterId());
			
			double price = showing.getPrice() * (Double) item.get("quantity");
			String theaterInfo = theater.getName() + " " + room.getRoomNumber();
			
			map.put("movieName", movie.getTitle());
			map.put("ticketQuantity", item.get("quantity"));
			map.put("price", price);
			map.put("theaterInfo", theaterInfo);
			map.put("time", showing.getStartTime());
			
			itemInfo.add(map);
		}
		
		request.setAttribute("itemInfo", itemInfo);
		request.setAttribute("order", order);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancelOrder.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}