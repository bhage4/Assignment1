package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		 * User Registration:
		 * The following section is used to create a properties object,
		 * then to access the properties file via it,
		 * store username and password
		 * This part should commented out to do registration via the User object
		 */
		
		/*Properties p = new Properties(); // Create a Properties object

		FileInputStream fis = null; // Create a FileInputStrem object

		try {		
			fis = new FileInputStream(propFilePath);
			p.load(fis); // Load data from the FileInputStrem object

			p.setProperty(userName, password); // Sets the property in the Properties object
			p.store(new FileOutputStream(propFilePath), null); // Writes the properties in the FileOutputStream object

			response.sendRedirect("Login.jsp"); // Link-redirection
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}*/

		// Uncomment the following block to do registration via the User object
		
		// Registration via the Users object
<<<<<<< HEAD
		Users aUser = new Users(userName, password);

		//First check whether the user already exists via methods from Users class
		if(aUser.checkUniqueUserName(propFilePath)){
			// Register the Users object
			aUser.registerUser(propFilePath);
			response.sendRedirect("Login.jsp"); 
		}
=======
		if(userName != null && password != null){
			Users aUser = new Users(userName, password);
			
			//First check whether the user already exists via methods from Users class
			aUser.validateUser(propFilePath);

			// Register the Users object
			aUser.registerUser(aUser, propFilePath);			
		}

		
		response.sendRedirect("Login.jsp"); 


>>>>>>> 1f60b40a454ee4d04efc90be2116f1941a5986bd
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
