

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplyLoan extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String amount = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("cusUserName");
		
		Model model = new Model();
		int status = model.applyLoan(username, amount);
		response.sendRedirect(status == 1 
				? "/bankapp/applyLoanSuccess.jsp"
				: "/bankapp/applyLoanFail.html");
	}

}
