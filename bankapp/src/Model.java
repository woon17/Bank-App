
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Model {
	private Session session;

	public void createHibernateSession() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		System.out.println("connection to database is established");
		session = factory.getCurrentSession();
		System.out.println("Connected to Pf....");
	}

	// create
	public boolean registerCustomer(Customer c) {
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			System.out.println("model.registerCustomer success...");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return false;
		}
	}

	public int verifyLogin(Customer loginCusotmer) {
		session.beginTransaction();
		Customer cus = (Customer) session.get(Customer.class, loginCusotmer.getCusUserName());
		session.getTransaction().commit();
		if(cus==null) {
			return -1;// username is not existing in database
		}else {
			if(!cus.getCusPassword().equals(loginCusotmer.getCusPassword())) {
				return 0;// password not match
			}else {
				return 1;// both matched
			}
		}
	}
}
