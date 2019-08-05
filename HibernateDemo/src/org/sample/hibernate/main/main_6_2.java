package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_6;

/***
 * Persistent <------- Detached
 * 
 * Even though state of the detached object is not changed its is update while
 * converting to persistent object, as hibernate doesn't monitor the detached
 * objects state change.
 * 
 * @author nagesh_holur
 *
 */
public class main_6_2 {

	public static void main(String[] args) {

		// Here user object is Transient
		UserDetails_6 user = new UserDetails_6();

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			// Create
			// -------------------------------------------------------------------
			user.setName("N4SMH");
			user.setPlace("Davangere");
			session.save(user);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		// Here user object is Detached.

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			// Read
			// -------------------------------------------------------------------
			user = null;
			user = (UserDetails_6) session.get(UserDetails_6.class, 1);
			System.out.println(user.getName() + " place is " + user.getPlace());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		// Here user object is Detached.

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(user);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}
}
