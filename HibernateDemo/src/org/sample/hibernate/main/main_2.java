package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.Address_1;
import org.sample.hibernate.domain.Address_2;
import org.sample.hibernate.domain.UserDetails_1;
import org.sample.hibernate.domain.UserDetails_2;
/***
 * Eager and lazy initialization
 * 
 * @author nagesh_holur
 *
 */
public class main_2 {

	public static void main(String[] args) {

		UserDetails_1 user1 = new UserDetails_1();
		user1.setName("N4SMH");

		UserDetails_2 user2 = new UserDetails_2();
		user2.setName("N4SMH");

		Address_1 addr11 = new Address_1();
		addr11.setCity("Bengaluru");
		addr11.setPincode("506770");
		addr11.setState("Karnataka");
		addr11.setStreet("Millers road");

		Address_1 addr12 = new Address_1();
		addr12.setCity("Davangere");
		addr12.setPincode("577004");
		addr12.setState("Karnataka");

		user1.getAddresses2().add(addr12);
		user1.getAddresses2().add(addr12);

		Address_2 addr21 = new Address_2();
		addr21.setCity("Bengaluru");
		addr21.setPincode("506770");
		addr21.setState("Karnataka");
		addr21.setStreet("Millers road");

		Address_2 addr22 = new Address_2();
		addr22.setCity("Davangere");
		addr22.setPincode("577004");
		addr22.setState("Karnataka");

		user2.getAddresses1().add(addr21);
		user2.getAddresses1().add(addr22);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(user1);
			session.save(user2);

		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}

		user1 = null;
		user2 = null;

		session = sessionFactory.openSession();
		try {
			user1 = (UserDetails_1) session.get(UserDetails_1.class, 1);
			user2 = (UserDetails_2) session.get(UserDetails_2.class, 2);

		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			session.close();
		}

		// Eager fetch
		System.out.println("User2: " + user2.getName() + " : " + user2.getAddresses1().size());
		// By default lazy fetch
		System.out.println("User1: " + user1.getName() + " : " + user1.getAddresses2().size());

	}
}
