

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputUsername = req.getParameter("cusUserName");
		String inputPassword = req.getParameter("cusPassword");
		Model model = new Model();
		model.createHibernateSession();
		Customer loginCusotmer = new Customer(inputUsername, inputPassword);
		int verifyResult = model.verifyLogin(loginCusotmer);
		if(verifyResult == -1) {
			System.out.println("username invalid");
		}else if(verifyResult == 0) {
			System.out.println("password invalid");
		}else {
			System.out.println("Customer login successfully");
		}
		
	}
}
