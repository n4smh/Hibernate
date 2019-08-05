package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_6;

/***
 * CRUD operation.
 * 
 * Transient -------> Persistent -------> Detached Objects.
 * 
 * Change hbm2ddl property of hibernate.cfg.xml from create to update. Run
 * create in create mode and all other in update mode.
 * 
 * @author nagesh_holur
 *
 */
public class main_6_0_CRUD {

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

			// Read
			// -------------------------------------------------------------------
			// user = null;
			// user = (UserDetails_6) session.get(UserDetails_6.class, 1);
			// System.out.println(user.getName() + " place is " +
			// user.getPlace());

			// Update
			// -------------------------------------------------------------------
			// user.setPlace("Bengaluru");
			// session.update(user);
			// user = null;
			// user = (UserDetails_6) session.get(UserDetails_6.class, 1);
			// System.out.println(user.getName() + " place is " +
			// user.getPlace());

			// Delete
			// -------------------------------------------------------------------
			// session.delete(user);

			// Persist
			// -------------------------------------------------------------------
			// Here user object is Persistent. Any interaction of user object
			// with session object makes it persistent. Changes to user object
			// is monitored. State of user object during detach will be
			// reflected to db as update.
			// Run the below with create.
			user.setPlace("Bangalore");
			user.setPlace("Bengaluru");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();

		}

		// Detached
		// -------------------------------------------------------------------
		// Here user object is Detached. Hibernate doesn't track the user
		// object. Thus changes are not reflected to db.
		user.setPlace("Davangere");
	}
}
