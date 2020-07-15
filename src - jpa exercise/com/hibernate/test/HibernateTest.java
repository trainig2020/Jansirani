package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.FourWheeler;
import com.hibernate.model.TwoWheeler;
import com.hibernate.model.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		/*
		 * User user = new User(); Address address=new Address();
		 * user.setUserName("Jenni"); user.setJoinedDate(new Date());
		 * user.setDescription("Description of the user");
		 * address.setStreet("j.p nagar"); address.setCity("Tirupur");
		 * address.setState("Tamilnadu"); address.setPincode(641602);
		 * user.setAddress(address);
		 * 
		 * User user2=new User(); Address address1=new Address();
		 * user2.setUserName("Jansi"); user2.setJoinedDate(new Date());
		 * user2.setDescription("Description of the Jansi");
		 * address1.setStreet("s.p nagar"); address1.setCity("Coimbatore");
		 * address1.setState("Tamilnadu"); address1.setPincode(641618);
		 * user2.setAddress(address1);
		 */
		/*
		 * User user=new User(); Address address1=new Address();
		 * user.setUserName("Jenni"); user.setJoinedDate(new Date());
		 * user.setDescription("Description of the user");
		 * address1.setStreet("s.p nagar"); address1.setCity("Coimbatore");
		 * address1.setState("Tamilnadu"); address1.setPincode(641618);
		 * user.getAddress().add(address1);
		 */

		/*
		 * User user=new User(); user.setUserName("Jenni"); user.setJoinedDate(new
		 * Date()); user.setDescription("Description of the user"); Vehicle vehicle =
		 * new Vehicle(); vehicle.setVehicleName("Innova");
		 * user.getVehicle().add(vehicle); vehicle.getUser().add(user);
		 * 
		 * User user2=new User(); user2.setUserName("Jansi"); user2.setJoinedDate(new
		 * Date()); user.setDescription("Description of the Jansi"); Vehicle vehicle1 =
		 * new Vehicle(); vehicle1.setVehicleName("Duster");
		 * user2.getVehicle().add(vehicle1); vehicle1.getUser().add(user2);
		 */

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Splendor");
		bike.setSteeringHandle("Bike steering handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Innova");
		car.setSteeringHandle("Car steering handle");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// session.save(user);
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();

		/*
		 * user = null; session = sessionFactory.openSession();
		 * session.beginTransaction(); user= session.get(User.class, 1);
		 * System.out.println("User name retrieved is :"+user.getUserName());
		 */

	}

}
