

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Singin
 */
public class register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cusName = req.getParameter("cusName");
		String cusUserName = req.getParameter("cusUserName");
		String cusPassword = req.getParameter("cusPassword");
		
		Customer newCustomer = new Customer(cusName, cusUserName, cusPassword);		
		Model model = new Model();
		model.createHibernateSession();
		boolean result = model.registerCustomer(newCustomer);
		
		if(result) {
			resp.sendRedirect("/bankapp/index.html");
		}else {
			resp.sendRedirect("/bankapp/registerFail.html");
		}
		System.out.println("register servlet works");
		
		
	}

}
