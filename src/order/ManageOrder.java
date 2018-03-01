package order;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet("/ManageOrder")
public class ManageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageOrder() {
        super();
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrdersDB odb = new OrdersDB();
		Orders order = odb.getOrder(orderId);
		
		MovieShowingDB msdb = new MovieShowingDB();
		MoviesDB mdb = new MoviesDB();
		TheatersDB tdb = new TheatersDB();
		
		List<HashMap> orderItems = new ArrayList<HashMap>();
		
		for(HashMap item: order.getOrderItems()){
			HashMap map = new HashMap(7);
			
			MovieShowing showing = msdb.getShowing((Integer) item.get("showingId"));
			Movie movie = mdb.getMovie(showing.getMovieId());
			Showroom room = tdb.getShowroom(showing.getShowroomId());
			Theatres theater = tdb.getTheater(room.getTheaterId());
			
			int quantity = (Integer) item.get("quantity");
			double price = quantity * showing.getPrice();
			
			String theaterName = theater.getName() + " " + room.getRoomNumber();
			
			map.put("title", movie.getTitle());
			map.put("quantity", quantity);
			map.put("price", price);
			map.put("theater", theaterName);
			map.put("time", showing.getStartTime());
			map.put("itemId", item.get("itemId"));
			
			Timestamp date = new Timestamp(System.currentTimeMillis());
			
			if(showing.getStartTime().after(date)){
				map.put("validCancel", true);
			}
			else{
				map.put("validCancel", false);
			}
			orderItems.add(map);
		}
		request.setAttribute("id", order.getId());
		request.setAttribute("totalCost", order.getTotalCost());
		request.setAttribute("date", order.getOrderDate());
		request.setAttribute("orderItems", orderItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageOrder.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}