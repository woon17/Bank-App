
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Singin
 */
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cusName = req.getParameter("cusName");
		String cusUserName = req.getParameter("cusUserName");
		String cusPassword = req.getParameter("cusPassword");

		Customer newCustomer = new Customer(cusName, cusUserName, cusPassword);
		Model model = new Model();
		model.createHibernateSession();
		boolean result = model.registerCustomer(newCustomer);

		if (result) {
			HttpSession session = req.getSession(true);// create a new session
			session.setAttribute("cusUserName", cusUserName);
			resp.sendRedirect("/bankapp/customerLoginSuccess.jsp");
		} else {
			resp.sendRedirect("/bankapp/registerFail.html");
		}
		System.out.println("register servlet works");

	}

}
