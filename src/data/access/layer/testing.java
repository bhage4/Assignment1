package data.access.layer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CreditCard;
import models.Movie;
import models.MovieShowing;
import models.Theatres;
import models.Users;

/**
 * Servlet implementation class testing
 */
@WebServlet("/testing")
public class testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();	
		/*Date d = new Date(1);
		CreditCard cc = new CreditCard(1, "bob", 1234,
			20.0, "mastercard", 1, "abc",
			d);
		CreditCardsDB db = new CreditCardsDB();
		db.addCard(cc);*/
		
		TheatersDB tdb = new TheatersDB();
		List<Theatres> theatersList = tdb.getAllTheaters();
		
		//MovieShowingDB db = new MovieShowingDB();
		//Movie mov = db.getMovie(1);
		//Movie mov = db.getMovie("Interstellar");
		//List<MovieShowing> movies = db.getAllShowings();
		for(Theatres t : theatersList){
			out.println(t.getName());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
