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
        
	
		//For creating table and insertin values
		/*	for(int i=0;i<10;i++) {
			User user=new User();
			user.setUserName("user"+i);
			session.save(user);
			}    */
		
		//Retrieving values
		
	/*	User user=session.get(User.class, 5);
		System.out.println("User name is  :" + user.getUserName());  */
		
		
		//For deleting an object
	/*	User user=session.get(User.class, 5);
		session.delete(user);   */
		
		//For updating an user value
		
	/*	User user=session.get(User.class, 6);
		user.setUserName("Jansi");
		session.update(user);   */
		
		session.getTransaction().commit();
		session.close();
	}

}
