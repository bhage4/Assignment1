package order;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.access.layer.CreditCardsDB;
import data.access.layer.MovieShowingDB;
import data.access.layer.OrdersDB;
import data.access.layer.UsersDB;
import models.CreditCard;
import models.MovieShowing;
import models.Orders;
import models.Transactions;
import models.Users;

@WebServlet("/CustomerTransactionConfirmation")
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerTransactionConfirmation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cardNumber = request.getParameter("cardNumber");
		String secCode = request.getParameter("securityCode");
		Date expDate = Date.valueOf(request.getParameter("expDate"));
		String cardType = request.getParameter("cardType");
		double balanceAdded = Double.parseDouble(request.getParameter("balance"));
		
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String name = fName + " " + lName;
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		double price = (Double) session.getAttribute("totalPrice");
		List<HashMap> cart = (List<HashMap>) session.getAttribute("cart");
		
		CreditCardsDB ccdb = new CreditCardsDB();
		CreditCard checkCard = ccdb.getCard(user.getId());
		
		CreditCard card = new CreditCard(name, cardNumber, cardType, user.getId(), secCode, expDate);

		if(checkCard == null){
			ccdb.addCard(card);
		}
		Transactions transaction = ccdb.getTransaction(user.getId());
		double newBalance = balanceAdded + transaction.getBalance();
		transaction.setBalance(newBalance);
		ccdb.updateBalance(transaction);

		if(card.validateCreditCardInfo(price, newBalance, checkCard)){
			newBalance -= price;
			if(newBalance<0){
				request.setAttribute("status", "funds");
				RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerTransactionConfirmation.jsp");
			    dispatcher.forward(request, response);
			}
			transaction.setBalance(newBalance);
			ccdb.updateBalance(transaction);
			
			String billStreet = request.getParameter("billStreet");
			String billCity  = request.getParameter("billCity");
			String billState = request.getParameter("billState");
			String billZip = request.getParameter("billZip");
			
			String billAddress = billStreet + " " + billCity + " " + billState + " " + billZip;
			
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			
			List<HashMap> orderItems = new ArrayList<HashMap>();
			for(HashMap item: cart){
				HashMap map = new HashMap(6);
				map.put("showingId", item.get("showingId"));
				map.put("quantity", item.get("ticketQuantity"));
				map.put("itemId", null);
				map.put("movieName", item.get("movieName"));
				map.put("price", item.get("price"));
				map.put("theater", item.get("theaterNameNum"));
				orderItems.add(map);
			}
			
			Orders order = new Orders(user.getId(), price, date, billAddress, orderItems, cardNumber);
			OrdersDB odb = new OrdersDB();
			int orderId = odb.addOrder(order);
			order.setId(orderId);
			
			MovieShowingDB msdb = new MovieShowingDB();
			for(HashMap item: orderItems){
				MovieShowing showing = msdb.getShowing((Integer) item.get("showingId"));
				int num = 0;
				synchronized(this){
					num = showing.getNumberPurchased() + (Integer) item.get("quantity");
				}
				showing.setNumberPurchased(num);
				msdb.updatePurchased(showing);
			}
			UsersDB udb = new UsersDB();
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setAddress(billAddress);
			user.setCity(billCity);
			user.setPostalCode(Integer.parseInt(billZip));
			user.setState(billState);
			user.setUserType("customer");
			udb.updateUser(user);
			
			double totalPrice = (Double) session.getAttribute("totalPrice");
			session.removeAttribute("totalPrice");
			session.removeAttribute("cart");
			
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("order", order);
			request.setAttribute("status", "valid");
		}
		else{
			request.setAttribute("status", "payment");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerTransactionConfirmation.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}