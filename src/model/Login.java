package model;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		/* The users.properties file is stored in the "WEB-INF" folder.
			   To access this file, you will need its absolute path. */

		/*
		 * Note: the content of the properties file may not be visible
		 */

		/* Following two statements are used to obtain the absolute path 
			   of the users.properties file from its relative path. */
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");

		/*
		 * Instead using servlet methods (above) for user login,
		 * instantiate a Users object and 
		 * use appropriate method for user login from the Users class.
		 */
		Users user = new Users(userName,password);

		boolean isValid = user.validateUser(propFilePath);

		if(isValid) {			
			// Redirect to home page
			response.sendRedirect("CustomerHomePage.jsp");
		} else {
			response.sendRedirect("Registration.jsp"); //Redirect to register page
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//	DONE The set of user names and passwords are saved in a Java Properties file managed by a
	//	java class named Users.
	//	DONE The servlet will validate user login/password through the Users class.
	//	DONE With a valid user login/password, the servlet redirects the user to the user home page.
	//	
	//	DONE With an invalid user login/password, the servlet redirects the user to the Registration
	//	page.
}
