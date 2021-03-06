package com.dxc.bankapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.bankapp.entity.Customer;
import com.dxc.bankapp.entity.Transaction;

public class Model {
	private Session dbSession;
	private Customer loginCustomer;

	/**
	 * Set the loginCustomer in the Model object.
	 *
	 * @param loginCustomer loginCustomer is customer who tries to login
	 * 
	 */
	public void setLoginCustomer(Customer loginCustomer) {
		this.loginCustomer = loginCustomer;
	}

	/**
	 * Create the session factory to make connection to database.
	 */
	public void connectCustomer() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Transaction.class).buildSessionFactory();
		dbSession = factory.getCurrentSession();
		System.out.println("connection to database is established");
	}

	/**
	 * Returns {@code true} if the customer is registered successfully.
	 *
	 * @param c customer who is registered
	 * 
	 * @return {@code true} if the customer is registered successfully
	 */
	public boolean registerCustomer(Customer c) {
		try {
			dbSession.beginTransaction();
			dbSession.save(c);
			dbSession.getTransaction().commit();
			System.out.println("model.registerCustomer success...");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns {@code true} if the loginCustomer is existing in database.
	 * 
	 * @return {@code true} if the loginCustomer is existing in database
	 */
	public int verifyLogin() {
		try {
			dbSession.beginTransaction();
			Customer cus = (Customer) dbSession.get(Customer.class, this.loginCustomer.getCusUserName());
			dbSession.getTransaction().commit();
			if (cus == null) {
				return -1;// username is not existing in database
			} else {
				if (!cus.getCusPassword().equals(this.loginCustomer.getCusPassword())) {
					return 0;// password not match
				} else {
					return 1;// both matched
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("verifyLogin catch block, check database password");
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * Returns 1 if the inputNewPassword is changed successfully.
	 * 
	 * @param inputNewPassword new password to change
	 * 
	 * @return 1 if the inputNewPassword is changed successfully
	 */
	public int changePassword(String inputNewPassword) {
		if (this.loginCustomer.getCusPassword().equals(inputNewPassword)) {
			return 0;// new password is the same as old password
		} else {
			dbSession.beginTransaction();
			Customer cus = (Customer) dbSession.get(Customer.class, this.loginCustomer.getCusUserName());
			cus.setCusPassword(inputNewPassword);
			dbSession.update(cus);
			dbSession.getTransaction().commit();
			return 1;// new password updated
		}

	}

	/**
	 * Returns customer's account balance.
	 * 
	 * @param cusUserName custormer's name
	 * 
	 * @return customer's account balance
	 */
	public int checkBalance(String cusUserName) {
		dbSession.beginTransaction();
		Customer cus = (Customer) dbSession.get(Customer.class, cusUserName);
		dbSession.getTransaction().commit();
		return cus.getCusBalance();

	}

	/**
	 * Returns the amount of withdrawal if withdraw action is successful.
	 * 
	 * @param user   custormer's name
	 * @param amount amount to withdraw
	 * 
	 * @return the amount of withdrawal if withdraw action is successful, or -1 if
	 *         withdraw action is unsuccessful, or -2 if query throw exception.
	 */
	public int withdrawMoney(String user, String amount) {
		try {

			dbSession.beginTransaction();
			List<Customer> customerList = dbSession.createQuery("FROM Customer c WHERE c.cusUserName = :user")
					.setParameter("user", user).list();

			int retrievedAmt = customerList.get(0).getCusBalance();
			int withdrawAmt = Integer.parseInt(amount);

			if (retrievedAmt >= withdrawAmt) {
				int finalAmt = retrievedAmt - withdrawAmt;

				// Update CUSTOMER DB Balance
				customerList.get(0).setCusBalance(finalAmt);
				dbSession.update(customerList.get(0));
				System.out.println("Updated CUSTOMER DB!");

				// Insert Transaction Record to DB
				Transaction t = new Transaction(user, getCurrentDate(), "CREDIT", withdrawAmt, "WITHDRAWAL",
						"APPROVED");
				dbSession.save(t);
				System.out.println("Updated TRANSACTION DB!");

				// Once both tables done, commit all transactions
				dbSession.getTransaction().commit();
				System.out.println("Withdrawal Successful.");
				return finalAmt;
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

	/**
	 * Returns 1 if apply Loan action is successful.
	 * 
	 * @param user   custormer's name
	 * @param amount amount for loan
	 * 
	 * @return 1 if apply Loan action is successful
	 */
	public int applyLoan(String user, String amount) {
		try {
			int loanAmt = Integer.parseInt(amount);
			Transaction t = new Transaction(user, getCurrentDate(), "DEBIT", loanAmt, "LOAN REQUEST", "APPROVED");
			dbSession.beginTransaction();
			dbSession.save(t);
			System.out.println("Updated TRANSACTION DB!");

			List<Customer> customerList = dbSession.createQuery("FROM Customer c WHERE c.cusUserName = :user")
					.setParameter("user", user).list();
			int retrievedAmt = customerList.get(0).getCusBalance();
			customerList.get(0).setCusBalance(loanAmt + retrievedAmt);
			dbSession.update(customerList.get(0));
			System.out.println("Updated CUSTOMER DB!");

			dbSession.getTransaction().commit();
			System.out.println("Loan Application Submitted successfully.");

			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Returns a list of transaction within the given period.
	 * 
	 * @param startDate the starting data of the period
	 * @param endDate   the ending date of the period
	 * 
	 * @return a list of transaction within the given period
	 */
	public List<Transaction> viewStatement(String startDate, String endDate, String user) {
		List<Transaction> transactionList = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			Date start_tx_date = sdf.parse(dateConvert(startDate));
			Date end_tx_date = sdf.parse(dateConvert(endDate));

			if (start_tx_date.before(end_tx_date) || start_tx_date.equals(end_tx_date)) {
				dbSession.beginTransaction();
				transactionList = dbSession.createQuery(
						"FROM Transaction t WHERE t.tx_date >= :startDate AND t.tx_date <= :endDate AND t.username = :user")
						.setParameter("startDate", start_tx_date).setParameter("endDate", end_tx_date)
						.setParameter("user", user).list();
				dbSession.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	/*
	 * -------------------------- Date Helper Methods -----------------------------
	 */

	/**
	 * Returns today's date.
	 *
	 * @return today's date
	 */
	public Date getCurrentDate() {
		Date tx_date = null;
		try {
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			String dateOnly = dateFormat.format(currentDate);
			tx_date = dateFormat.parse(dateOnly);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tx_date;
	}

	/**
	 * Returns a date in dd/MMM/yyyy string format
	 *
	 * @param input input is a string format of date
	 * 
	 * @return a date in dd/MMM/yyyy string format
	 */
	public String dateConvert(String input) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MMM/yyyy");
		Date date = null;
		try {
			date = format1.parse(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String dateString = format2.format(date);
		dateString = dateString.replace("-", " ");
		return ((dateString));
	}
}
