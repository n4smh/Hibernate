package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_7;

/***
 * HQL
 * 
 * Fetching record using HQL. Uses domain object to query rather than table and
 * column names used in SQL.
 * 
 * Positional and named parameter holder.
 * 
 * @author nagesh_holur
 *
 */
public class main_7_1 {

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
		List<UserDetails_7> list = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			query = session.createQuery("from UserDetails_7");
			list = query.list();
			System.out.println("No of record in table UserDetails_7 is " + list.size());
			printUserDetails_7(list);

			query = session.createQuery("from UserDetails_7 where id >= 5 and id <= 8");
			list = query.list();
			System.out.println("No of record with id in range 5-8  is " + list.size());
			printUserDetails_7(list);
			
			// Positional parameter holder
			query = session.createQuery("from UserDetails_7 where id >= ? and name = ?");
			query.setInteger(0, 5);
			query.setString(1, "User_8");
			list = query.list();
			printUserDetails_7(list);
			
			// Named parameter holder
			query = session.createQuery("from UserDetails_7 where id >= :id and name = :name");
			query.setInteger("id", 5);
			query.setString("name", "User_8");
			list = query.list();
			printUserDetails_7(list);

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
}
