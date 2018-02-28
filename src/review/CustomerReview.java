package review;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
import models.Users;

@WebServlet("/CustomerReview")
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String reviewText = request.getParameter("content");
		String reviewRating = request.getParameter("stars");
		Review newReview = new Review();
		
		Movie movie = (Movie) session.getAttribute("movie");
		Users user = (Users) session.getAttribute("user"); //This created user's id is 0 for some reason
		
		Date reviewDate = new  Date(System.currentTimeMillis());
		
		newReview.setReview(reviewText);
		newReview.setRating(reviewRating);
		newReview.setMovieId(movie.getId());
		newReview.setUser(user);
		newReview.setReviewDate(reviewDate);
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
