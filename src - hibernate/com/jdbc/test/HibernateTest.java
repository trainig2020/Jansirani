package com.jdbc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.model.FourWheeler;
import com.jdbc.model.TwoWheeler;
import com.jdbc.model.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Splendor");
		bike.setSteeringHandle("Bike steering handle");
		
		FourWheeler car= new FourWheeler();
		car.setVehicleName("Innova");
		car.setSteeringHandle("Innova steering handle");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
	}

}
