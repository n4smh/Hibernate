package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_7_1;

/***
 * Named query and Named native query
 * 
 * @author nagesh_holur
 *
 */
public class main_7_3 {

	public static void main(String[] args) {

		UserDetails_7_1 user = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			for (int i = 1; i <= 10; i++) {
				// Create
				// -------------------------------------------------------------------
				// user = new UserDetails_7_1();
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
			query = session.getNamedQuery("UserDetails_7_1.byId");
			query.setInteger("id", 5);
			query.setString("name", "User_8");
			list = query.list();
			printUserDetails_7_1(list);

			query = session.getNamedQuery("UserDetails_7_1.byIdNativeSQL");
			query.setInteger("id", 5);
			query.setString("name", "User_8");
			list = query.list();
			printUserDetails_7_1(list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	static void printUserDetails_7_1(List<UserDetails_7_1> userList) {
		for (UserDetails_7_1 user : userList) {
			System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPlace());
		}
	}

}
