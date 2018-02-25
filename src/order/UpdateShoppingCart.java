package order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Movie;
import models.MovieShowing;
import models.Theatres;

@WebServlet("/UpdateShoppingCart")
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateShoppingCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Movie movie = (Movie) request.getAttribute("movie");
		Theatres theater = (Theatres) request.getAttribute("theater");
		MovieShowing showing = (MovieShowing) request.getAttribute("showing");
		int quantity = (Integer) request.getAttribute("quantity");
		
		HttpSession session = request.getSession();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
//	Create a shopping cart session object if it doesn’t exist already. This shopping cart
//	session object is to be used for storing the shopping cart items temporarily. It
//	must be able to store the following information of each order item in the shopping
//	cart:
//	! Movie Identifier
//	! Requested ticket quantity by customer
//	4
//	! Movie name
//	! Movie poster thumbnail (link)
//	! Theatre name
//	! Showtime
//	! Price
//	o After receiving the movie and requested quantity of tickets to the shopping cart,
//	obtain the remaining movie information from the Movie object and store the
//	information in the shopping cart session object.
//	o This servlet should also handle delete requests to delete the items from the
//	shopping cart, which means removing from the shopping cart session object.
//	o After handling an update (add or delete) request, it should verify the availability
//	of the movie tickets for the specified showing based on the requested quantity. If
//	success, compute the total cost of the entire shopping cart.
//	o Now redirect the customer to the View & Checkout Shopping Cart jsp page with
//	all the above shopping cart information stored in the session object.

}
