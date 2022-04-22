package com.dxc.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.bankapp.entity.Transaction;
import com.dxc.bankapp.model.Model;

/**
 * Servlet implementation class ViewStatement
 */
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
		
		if(transactionList == null) {
			response.sendRedirect("/bankapp/viewStatementView/viewStatementInvalidDate.html");
		}else {
			if (!transactionList.isEmpty()) {
				session.setAttribute("data", transactionList);
				response.sendRedirect("/bankapp/viewStatementView/viewStatementSuccess.jsp");
			} else {
				response.sendRedirect("/bankapp/viewStatementView/viewStatementNoTransaction.html");
			}
		}
	}

}
