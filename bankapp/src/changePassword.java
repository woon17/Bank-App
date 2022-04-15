
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class changePassword
 */
public class changePassword extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputOldPassword = req.getParameter("oldPassword");
		String inputNewPassword = req.getParameter("newPassword");
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("cusUserName");
		System.out.println(String.format("username: %s; input old password: %s; old password: %s", username, inputNewPassword, inputOldPassword));
		
		Model model = new Model();
		model.createHibernateSession();
		Customer loginCustomer = new Customer(username, inputOldPassword);
		model.setLoginCustomer(loginCustomer);
		int oldPasswordResult = model.verifyLogin();
		
		if (oldPasswordResult == 1) {
			model.createHibernateSession();
			int passwordUpdateResult = model.changePassword(inputNewPassword);
			if(passwordUpdateResult ==0) {
				System.out.println("new password is the same as the old password");
			}else {
				System.out.println("new password updated successfully");
			}
		}else if(oldPasswordResult == 0){
			System.out.println("old password in incorrect");
		}
		
	}

}
