package order;

import java.io.IOException;
import java.util.Date;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int orderId = (Integer) request.getAttribute("orderId");
		OrdersDB odb = new OrdersDB();
		Orders order = odb.getOrder(orderId);
		
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(order.getShowingId());
		
		MoviesDB mdb = new MoviesDB();
		Movie movie = mdb.getMovie(showing.getMovieId());
		
		TheatersDB tdb = new TheatersDB();
		Showroom room = tdb.getShowroom(showing.getShowroomId());
		Theatres theater = tdb.getTheater(room.getTheaterId());
		
		if(showing.getStartTime().after(new Date())){
			request.setAttribute("validCancel", false);
		}
		else{
			request.setAttribute("validCancel", true);
		}
		
		request.setAttribute("showing", showing);
		request.setAttribute("room", room);
		request.setAttribute("theater", theater);
		request.setAttribute("order", order);
		request.setAttribute("movie", movie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageOrder.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}