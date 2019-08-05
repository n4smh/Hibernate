package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.sample.hibernate.domain.UserDetails_7;

/***
 * Query by example.
 * 
 * It ignores primary key and null property value.
 * 
 * Hibernate specific, not JPA standard.
 * 
 * 
 * @author nagesh_holur
 *
 */
public class main_7_6 {

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

		Criteria criteria = null;
		List list = null;
		UserDetails_7 exampleUser = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			exampleUser = new UserDetails_7();
			// exampleUser.setId(5);
			exampleUser.setName("User_1%");

			Example example = Example.create(exampleUser);
			// Ignores while filtering even if the value is set.
			// example.excludeProperty("name");
			example.enableLike();

			criteria = session.createCriteria(UserDetails_7.class);
			criteria.add(example);
			list = criteria.list();
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
