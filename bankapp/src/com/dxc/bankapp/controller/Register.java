package com.dxc.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.bankapp.entity.Customer;
import com.dxc.bankapp.model.Model;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cusName = req.getParameter("cusName");
		String cusUserName = req.getParameter("cusUserName");
		String cusPassword = req.getParameter("cusPassword");

		Customer newCustomer = new Customer(cusName, cusUserName, cusPassword);
		Model model = new Model();
		model.connectCustomer();
		boolean result = model.registerCustomer(newCustomer);

		if (result) {
			HttpSession session = req.getSession(true);// create a new session
			session.setAttribute("cusUserName", cusUserName);
			resp.sendRedirect("/bankapp/loginView/customerLoginSuccess.jsp");
		} else {
			resp.sendRedirect("/bankapp/registerView/registerFail.html");
		}

	}

}
