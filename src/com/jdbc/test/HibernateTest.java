package com.jdbc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.model.User;

public class HibernateTest {

	public static void main(String[] args) {
		
	
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User user = session.get(User.class, 1);
		session.getTransaction().commit();
		session.close();
		
	user.setUserName("Jansirani");

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);  
//		user.setUserName("Jansirani - B.E");
		session.getTransaction().commit();
		session.close();

	}

}
