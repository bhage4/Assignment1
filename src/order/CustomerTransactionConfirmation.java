package order;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.access.layer.CreditCardsDB;
import models.CreditCard;
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
		int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
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
		
		CreditCardsDB ccdb = new CreditCardsDB();
		CreditCard checkCard = ccdb.getCard(cardNumber);
		
		CreditCard card = new CreditCard(name, cardNumber, cardType, user.getId(), secCode, expDate);

		if(checkCard == null){
			ccdb.addCard(card);
		}
		Transactions transaction = ccdb.getTransaction(cardNumber);
		double newBalance = balanceAdded + transaction.getBalance();
		transaction.setBalance(newBalance);
		ccdb.updateBalance(transaction);

		if(card.validateCreditCardInfo(price)){
			session.removeAttribute("cart");
			newBalance -= price;
			transaction.setBalance(newBalance);
			ccdb.updateBalance(transaction);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
//	On success, order is placed using the Orders model
//	Redirects the customer to the Customer Transaction Confirmation jsp page with the order details and the transaction status. The Order number must be shown in this page. 
}