

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(); //use session from signin/register
		String cusUserName = (String) session.getAttribute("cusUserName");
		
		Model m = new Model();
		m.createHibernateSession();
		int cusBalance = m.checkBalance(cusUserName);
		System.out.println(cusBalance);
		session.setAttribute("cusBalance", cusBalance);
		resp.sendRedirect("/bankapp/displayBalance.jsp");
	}

}
