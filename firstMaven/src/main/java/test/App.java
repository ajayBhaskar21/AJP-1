package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// person p1 = new person(23, "Ravi", "VIGNAN", "8186906603");
		person p2 = new person(34, "Kishore", "VIGNAN", "9642759276");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		person p3 = new person(10, "Ajay", "Vignan", "981245365");
		person p4 = new person(10, "ram", "Vignan", "74585669");
		session.persist(p4);

		tx.commit();

		factory.close();
	}

}