
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class signin
 */
public class Signin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputUsername = req.getParameter("cusUserName");
		String inputPassword = req.getParameter("cusPassword");
		Model model = new Model();
		model.createHibernateSession();
		Customer loginCusotmer = new Customer(inputUsername, inputPassword);
		model.setLoginCustomer(loginCusotmer);
		int verifyResult = model.verifyLogin();
		if (verifyResult == -1) {
			System.out.println("username invalid");
			resp.sendRedirect("/bankapp/customerUsernameInvalid.html");
		} else if (verifyResult == 0) {
			System.out.println("password invalid");
			resp.sendRedirect("/bankapp/customerPasswordInvalid.html");
		} else {
			System.out.println("Customer login successfully");

			HttpSession session = req.getSession(true);// create a new session
			session.setAttribute("cusUserName", inputUsername);
			resp.sendRedirect("/bankapp/customerLoginSuccess.jsp");
			return;
		}

	}
}
