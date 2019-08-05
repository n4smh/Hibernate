package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_8;

/***
 * Caching L1
 * 
 * It's by default active. It is associated with each session. Cache expires
 * when session closes.
 * 
 * Run with hbm2ddl.auto as create.
 * 
 * @author nagesh_holur
 *
 */

public class main_8_1 {

	public static void main(String[] args) {

		UserDetails_8 user = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			for (int i = 1; i <= 10; i++) {
				// Create
				// -------------------------------------------------------------------
				user = new UserDetails_8();
				user.setName("User_" + i);
				session.save(user);
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

			UserDetails_8 user1 = (UserDetails_8) session.get(UserDetails_8.class, 1);
			// user1.setPlace("BLR");
			// user1.setPlace("DVG");

			// Call is made to db only once even there is multiple get. Once the
			// object is persisted it's saved in L1 cache. All preceding calls
			// fetches data in cache, rather than calling db.
			//
			// Check the id to be picked before run
			UserDetails_8 user2 = (UserDetails_8) session.get(UserDetails_8.class, 1);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			UserDetails_8 user1 = (UserDetails_8) session.get(UserDetails_8.class, 1);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

}
