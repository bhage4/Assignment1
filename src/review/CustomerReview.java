package review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.access.layer.ReviewDB;

import models.Movie;
import models.Review;

@WebServlet("/CustomerReview")
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Review newReview = (Review) session.getAttribute("review");
		Movie movie = (Movie) session.getAttribute("movie");
		
		ReviewDB rdb = new ReviewDB();
		rdb.addReview(newReview);
		
		if(newReview.validateReview()){
			request.setAttribute("result", true);
		}
		else{
			request.setAttribute("result", false);
		}
		request.setAttribute("movie", movie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerReviewConfirmation.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	The servlet should redirect the user to the ReviewConfirmation page with a success or failure message, accordingly. 

}
