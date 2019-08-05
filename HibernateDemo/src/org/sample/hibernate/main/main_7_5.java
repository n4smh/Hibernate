package org.sample.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sample.hibernate.domain.UserDetails_7;

/***
 * Criteria API and Projections.
 * 
 * Hibernate specific, not JPA standard.
 * 
 * @author nagesh_holur
 *
 */
public class main_7_5 {

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

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			criteria = session.createCriteria(UserDetails_7.class);
			criteria.add(Restrictions.ge("id", 5));
			criteria.add(Restrictions.eq("name", "User_8"));
			list = criteria.list();
			printUserDetails_7(list);

			// OR Restriction
			criteria = session.createCriteria(UserDetails_7.class);
			criteria.add(Restrictions.or(Restrictions.between("id", 4, 6), Restrictions.between("id", 8, 10)));
			criteria.addOrder(Order.desc("id"));
			list = criteria.list();
			printUserDetails_7(list);

			criteria = session.createCriteria(UserDetails_7.class);
			criteria.setProjection(Projections.max("id"));
			list = criteria.list();
			System.out.println("List size is " + list.size());
			System.out.println("Max id value is " + list.get(0));

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
