package login;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.access.layer.MovieShowingDB;
import data.access.layer.TheatersDB;
import data.access.layer.UsersDB;
import models.MovieShowing;
import models.Theatres;
import models.Users;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UsersDB udb = new UsersDB();

		boolean exists = udb.checkIfExists(userName);
		boolean isValid = udb.validatePassword(userName, password);
		
		
		if(isValid && exists) {	
			Users user = udb.getUser(userName);
			
			TheatersDB tdb = new TheatersDB();
			List<Theatres> theatersList = tdb.getAllTheaters();
			
			MovieShowingDB msdb = new MovieShowingDB();
			List<MovieShowing> showings = msdb.getAllShowings();
			
			HashMap<String, String> showTimes = new HashMap<String, String>();
			for(MovieShowing showing: showings){
				String time = new SimpleDateFormat("yyyy-MM-dd").format(showing.getStartTime());
				showTimes.putIfAbsent(time, time);
			}
			
			HttpSession session = request.getSession();
			
			user.setNumOfVisits(user.getNumOfVisits()+1);
			udb.updateUser(user);
			
			session.setAttribute("user", user);
			session.setAttribute("theaters", theatersList);
			session.setAttribute("showTimes", showTimes);
			
			// Redirect to home page
			String address = "CustomerHomePage.jsp";
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);
		} else {
			response.sendRedirect("Registration.jsp"); //Redirect to register page
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
