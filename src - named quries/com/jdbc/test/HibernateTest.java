package com.jdbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jdbc.model.User;







public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

	
	
	/*	Query query=session.getNamedQuery("User.byId");
		query.setInteger("userId", 2); */
		
		//named queries
		
	/*	Query query = session.getNamedNativeQuery("User.byName");
		query.setString("userName", "user9");
		List<User> users =(List<User>)  query.list(); */
		
		//criteria query
	/*	Criteria criteria =session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", "user9"))
		.add(Restrictions.gt("userId", 5));
		criteria.add(Restrictions.or(Restrictions.between("userId", 3, 6),
				Restrictions.between("userId", 7, 9)));
		List<User> users =(List<User>)  criteria.list();   */
		
		//For Projection
		
		User user1 = new User();
		user1.setUserId(3);
		user1.setUserName("Rajkumar");
		
		Example example=Example.create(user1);
		
		Criteria criteria =session.createCriteria(User.class)
				.add(example);
		List<User> users =(List<User>)  criteria.list(); 

		session.getTransaction().commit();
		session.close();
	
		
		for(User u:users) {
			System.out.println(u.getUserName());
		}
		
	}

}
