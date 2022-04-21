package com.dxc.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.bankapp.model.Model;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(); //use session from signin/register
		String cusUserName = (String) session.getAttribute("cusUserName");
		
		Model m = new Model();
		m.connectCustomer();
		int cusBalance = m.checkBalance(cusUserName);
		session.setAttribute("cusBalance", cusBalance);
		resp.sendRedirect("/bankapp/checkBalanceView/displayBalance.jsp");
	}

}
