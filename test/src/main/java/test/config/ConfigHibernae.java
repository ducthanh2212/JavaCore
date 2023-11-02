package test.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigHibernae {
public static SessionFactory getSessionFactory() {
	
	Configuration config = new Configuration();
	try {
		
		config.configure("hibernate.cfg.xml");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return config.buildSessionFactory();
}
}
