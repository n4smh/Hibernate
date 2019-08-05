package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_8_1;

/***
 * Caching L3
 * 
 * Query caching
 * 
 * setCacheable is doing 2 task, first is caching itself and next it tells
 * hibernate to look for data in cache rather than hitting db directly.
 * 
 * <property name="cache.use_query_cache">true</property> must be appended in hibernate.cfg.xml.
 * 
 * @author nagesh_holur
 *
 */

public class main_8_3 {

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

			Query query = session.createQuery("from UserDetails_8_1 where id = 1").setCacheable(true);
			List<UserDetails_8_1> userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			// Query fetch is treated differently from session get. So it hits
			// db instead of cache lookup.
			// It has to be explicitly mentioned to cache query results.
			Query query = session.createQuery("from UserDetails_8_1 where id = 1").setCacheable(true);
			List<UserDetails_8_1> userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

}
