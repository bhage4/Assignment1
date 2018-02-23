package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.access.layer.UsersDB;
import models.Users;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registration() {
        super();
    }

   	@Override
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String userName = request.getParameter("userName");
   		String password = request.getParameter("password");

   		if(userName != null && password != null){
   			
   			Users aUser = new Users(userName, password);
   			UsersDB udb = new UsersDB();

   			//First check whether the user already exists via methods from Users class
   			if(!udb.checkIfExists(userName)){
   				// Register the Users object
   				udb.addUser(aUser);
   			}			
   		}
   		response.sendRedirect("Login.jsp"); 
   		
   	}

   	@Override
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doGet(request, response);
   	}
}
