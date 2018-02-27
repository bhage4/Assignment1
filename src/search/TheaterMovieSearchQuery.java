package search;

import java.sql.Date;
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
import models.Theatres;
import models.Showroom;
import models.MovieShowing;
import data.access.layer.MoviesDB;
import data.access.layer.TheatersDB;
import data.access.layer.MovieShowingDB;

@WebServlet("/TheaterMovieSearchQuery")
public class TheaterMovieSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TheaterMovieSearchQuery() {
        super();
    }
    
//TODO: make sure no query returns null; if one does, act accordingly
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String movieName = request.getParameter("name");
		String theaterName = request.getParameter("theaterSelected");
		Date viewDate = Date.valueOf(request.getParameter("dateSelected"));
		
		if(movieName != null && !movieName.isEmpty()){
					
			MoviesDB mdb = new MoviesDB();
			Movie movie = mdb.getMovie(movieName);
			
			TheatersDB tdb = new TheatersDB();
			Theatres theater = tdb.getTheater(theaterName);
			Showroom room = tdb.getShowroom(theater.getId());
			
			HashMap params = new HashMap(2);
			params.put("movieId", movie.getId());
			params.put("showRoomId", room.getId());
			params.put("date", viewDate);
			
			MovieShowingDB msdb = new MovieShowingDB();
			List<MovieShowing> showings = msdb.searchShowings(params);
			
			HttpSession session = request.getSession();
			session.setAttribute("showingList", showings);
			session.setAttribute("movie", movie);
			session.setAttribute("showroom", room);
			session.setAttribute("theater", theater);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieSearchResults.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}