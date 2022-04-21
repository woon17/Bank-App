

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewStatement extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String startDate = request.getParameter("start_date");
		String endDate = request.getParameter("end_date");

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("cusUserName");
		
		Model model = new Model();
		model.connectCustomer();
		List<Transaction> transactionList = model.viewStatement(startDate, endDate, username);
		PrintWriter pw = response.getWriter();
		
		if(transactionList == null) {
			pw.write("Invalid Date range, please try again!");
		}else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			if (!transactionList.isEmpty()) {
				pw.write("----------------------------------------------------------------\n");
				pw.write("Date \t\tNOTES \t\tTYPE \tAMOUNT \tSTATUS\n");
				pw.write("----------------------------------------------------------------\n");
				for(Transaction t : transactionList) {
					pw.write(dateFormat.format(t.getTx_date()) + "\t" + t.getNotes() + "\t" + t.getType() + "\t" + t.getAmount() + "\t" + t.getStatus() + "\n");
				}
				pw.write("----------------------------------------------------------------\n");
			} else {
				pw.write("There are no transaction records within the selected period.");
			}
		}
	}
	
}
