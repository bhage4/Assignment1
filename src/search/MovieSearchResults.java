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

import data.access.layer.ReviewDB;
import models.Movie;
import models.MovieShowing;
import models.Review;
import models.Showroom;
import models.Theatres;

@WebServlet("/MovieSearchResults")
public class MovieSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieSearchResults() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Movie movie = (Movie) request.getAttribute("movie");
		MovieShowing showing = (MovieShowing) request.getAttribute("showing");
		Theatres theater = (Theatres) request.getAttribute("theater");
		Showroom room = (Showroom) request.getAttribute("room");
		
		ReviewDB rdb = new ReviewDB();
		List<Review> reviews = rdb.getReviews(movie.getId());
		
		HttpSession session = request.getSession();
		session.setAttribute("showing", showing);
		session.setAttribute("movie", movie);
		session.setAttribute("showroom", room);
		session.setAttribute("theater", theater);
		session.setAttribute("reviews", reviews);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieDetailsSelection.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}