package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import test.config.ConfigHibernae;
import test.model.user;

public class HibernateMain {
	static final SessionFactory factor = ConfigHibernae.getSessionFactory();

	public static void main(String[] arg) {
		Session session = factor.openSession();
		Transaction tx = session.beginTransaction();
		user u = new user(0, null);
		u.setName("thanh");
		u.setPass("123");
		session.save(u);
		tx.commit();
		System.err.println("done");
	}
}
