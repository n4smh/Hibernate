package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_8_1;

/***
 * Caching L2
 * 
 * Its common across sessions. hibernate.cfg.xml and persistence object must be
 * configured for caching.
 * 
 * hibernate-ehcache-5.1.10.Final --> ehcache-2.10.1 --> slf4j-api-1.7.7
 * 
 * @author nagesh_holur
 *
 */

public class main_8_2 {

	public static void main(String[] args) {

		UserDetails_8_1 user = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			for (int i = 1; i <= 10; i++) {
				// Create
				// -------------------------------------------------------------------
				// user = new UserDetails_8_1();
				// user.setName("User_" + i);
				// session.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			UserDetails_8_1 user1 = (UserDetails_8_1) session.get(UserDetails_8_1.class, 1);
			// user1.setPlace("BLR");
			// user1.setPlace("DVG");

			UserDetails_8_1 user2 = (UserDetails_8_1) session.get(UserDetails_8_1.class, 1);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			UserDetails_8_1 user1 = (UserDetails_8_1) session.get(UserDetails_8_1.class, 1);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

}
