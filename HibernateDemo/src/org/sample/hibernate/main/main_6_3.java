package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_6_3;

/***
 * Persistent <------- Detached
 * 
 * Update changes only on change in state (State change check is achieved by
 * select). Its Hibernate specific, not a JPA standard.
 * 
 * @author nagesh_holur
 *
 */
public class main_6_3 {

	public static void main(String[] args) {

		// Here user object is Transient
		UserDetails_6_3 user = new UserDetails_6_3();

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
			user = (UserDetails_6_3) session.get(UserDetails_6_3.class, 1);
			System.out.println(user.getName() + " place is " + user.getPlace());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		// Here user object is Detached.
		// Update is call only if the user state is changed.
		// user.setPlace("Bengaluru");

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
