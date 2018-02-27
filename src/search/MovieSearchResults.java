package search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.access.layer.MovieShowingDB;
import data.access.layer.ReviewDB;
import models.MovieShowing;
import models.Review;

@WebServlet("/MovieSearchResults")
public class MovieSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieSearchResults() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int showingId = Integer.parseInt(request.getParameter("showingId"));
		
		ReviewDB rdb = new ReviewDB();
		List<Review> reviews = rdb.getReviews(movieId);
		
		MovieShowingDB msdb = new MovieShowingDB();
		MovieShowing showing = msdb.getShowing(showingId);
		
		HttpSession session = request.getSession();
		session.setAttribute("showing", showing);
		session.setAttribute("reviews", reviews);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieDetailsSelection.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}