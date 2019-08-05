package org.sample.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.Address_1;
import org.sample.hibernate.domain.UserDetails_1;

/***
 * Basic Domain object creation
 * 
 * Entity, Table, Id, Column, JoinTable, JoinColumn, Embeddable, Transient,
 * Temporal, AttributeOverrides, AttributeOverride, ElementCollection, Lob
 * 
 * @author nagesh_holur
 *
 */
public class main_1 {

	public static void main(String[] args) {

		UserDetails_1 user1 = new UserDetails_1();
		user1.setName("N4SMH");

		user1.setAddress(new Address_1());
		user1.getAddress().setCity("Bengaluru");
		user1.getAddress().setPincode("506770");
		user1.getAddress().setState("Karnataka");
		user1.getAddress().setStreet("Millers road");

		user1.setHomeAddress(new Address_1());
		user1.getHomeAddress().setCity("Davangere");
		user1.getHomeAddress().setPincode("577004");
		user1.getHomeAddress().setState("Karnataka");

		user1.setCurrentDate(new Date());

		user1.setDescription("Large description");

		UserDetails_1 user2 = new UserDetails_1();
		user2.setName("SMH");

		user1.getAddresses1().add(user1.getAddress());
		user1.getAddresses1().add(user1.getHomeAddress());

		user1.getAddresses2().add(user1.getAddress());
		user1.getAddresses2().add(user1.getHomeAddress());

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(user1);
			session.save(user2);

		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			session.getTransaction().commit();
			session.close();
		}

		UserDetails_1 user = null;
		session = sessionFactory.openSession();
		try {
			user = (UserDetails_1) session.get(UserDetails_1.class, 1);

		} catch (Exception e) {
			System.out.println("Exception get");
		} finally {
			session.close();
		}

		System.out.println("User name: " + user.getName());

	}
}
