package com.jdbc.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.model.User;







public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
		  //For creating table and inserting values
	/*	for(int i=0;i<10;i++) {
			User user=new User(); 
			user.setUserName("user"+i); session.save(user); }  */
		 

	/*	Query query=session.createQuery("select userName from User");
		query.setFirstResult(5);
		query.setMaxResults(4);  **/
		
		//parameterized queries
		String minUserId="5";
		String userName="User9";
		Query query=session.createQuery("from User where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		List<User> users =(List<User>)  query.list(); 
		

		session.getTransaction().commit();
		session.close();
	//	System.out.println("size of list result :" + users.size());
		
		for(User u:users) {
			System.out.println(u.getUserName());
		}
		
	}

}
