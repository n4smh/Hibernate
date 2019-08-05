package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.UserDetails_4;
import org.sample.hibernate.domain.Vehicle_4_1;

/***
 * ManyToMany mapping.
 * 
 * @author nagesh_holur
 *
 */
public class main_4 {

	public static void main(String[] args) {

		UserDetails_4 user1 = new UserDetails_4();
		user1.setName("N4SMH_1");

		UserDetails_4 user2 = new UserDetails_4();
		user2.setName("N4SMH_2");

		Vehicle_4_1 vehicle1 = new Vehicle_4_1();
		vehicle1.setName("Btwin Rockrider 300");

		Vehicle_4_1 vehicle2 = new Vehicle_4_1();
		vehicle2.setName("GS150R");

		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		user2.getVehicles().add(vehicle1);
		user2.getVehicles().add(vehicle2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(user1);
			session.save(user2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
}
