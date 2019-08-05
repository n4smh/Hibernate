package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_7;

/***
 * HQL Pagination and selected property fetch
 * 
 * @author nagesh_holur
 *
 */
public class main_7_2 {

	public static void main(String[] args) {

		UserDetails_7 user = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			for (int i = 1; i <= 10; i++) {
				// Create
				// -------------------------------------------------------------------
				// user = new UserDetails_7();
				// user.setName("User_" + i);
				// session.save(user);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}

		Query query = null;
		List list = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			query = session.createQuery("from UserDetails_7");

			// Skips first 2 record fetch.
			query.setFirstResult(2);

			// Max no of record fetched is restricted to 4.
			query.setMaxResults(4);

			list = query.list();
			printUserDetails_7(list);

			query = session.createQuery("select name from UserDetails_7");
			list = query.list();
			printListString(list);

			query = session.createQuery("select max(id) from UserDetails_7");
			list = query.list();
			System.out.println("List size is " + list.size());
			System.out.println("Max id " + list.get(0));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	static void printUserDetails_7(List<UserDetails_7> userList) {
		for (UserDetails_7 user : userList) {
			System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPlace());
		}
	}

	static void printListString(List<String> stringList) {
		for (String str : stringList) {
			System.out.println(str);
		}
	}

}
