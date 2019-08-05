package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.Address_3;
import org.sample.hibernate.domain.UserDetails_3;
import org.sample.hibernate.domain.Vehicle_3_1;
import org.sample.hibernate.domain.Vehicle_3_2;
import org.sample.hibernate.domain.Vehicle_3_3;

/***
 * Storing object within other object. OneToOne, OneToMany, OneToMany without
 * mapping table, ManyToOne and inverse reference through ManyToOne. NotFound is
 * a hibernate functionality to suppress not found exception.
 * 
 * @author nagesh_holur
 *
 */
public class main_3 {

	public static void main(String[] args) {

		UserDetails_3 user = new UserDetails_3();
		user.setName("N4SMH");

		Vehicle_3_1 vehicle = new Vehicle_3_1();
		vehicle.setName("Btwin Rockrider 300");

		Vehicle_3_2 vehicle1 = new Vehicle_3_2();
		vehicle1.setName("Btwin Rockrider 300");

		Vehicle_3_2 vehicle2 = new Vehicle_3_2();
		vehicle2.setName("GS150R");

		Vehicle_3_3 vehicle3 = new Vehicle_3_3();
		vehicle3.setName("Btwin Rockrider 300");

		Vehicle_3_3 vehicle4 = new Vehicle_3_3();
		vehicle4.setName("GS150R");

		user.setVehicle(vehicle);
		user.getVehicles1().add(vehicle1);
		user.getVehicles1().add(vehicle2);
		user.getVehicles2().add(vehicle3);
		user.getVehicles2().add(vehicle4);

		vehicle3.setUser(user);
		vehicle4.setUser(user);

		Address_3 addr31 = new Address_3();
		addr31.setCity("Bengaluru");
		addr31.setPincode("506770");
		addr31.setState("Karnataka");
		addr31.setStreet("Millers road");

		user.setAddress_3(addr31);
		UserDetails_3 user2 = new UserDetails_3();
		user2.setName("N4SMH2");
		user2.setAddress_3(addr31);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(user);
			session.save(user2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
}
