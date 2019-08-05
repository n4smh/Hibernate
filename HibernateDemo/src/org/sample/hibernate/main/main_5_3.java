package org.sample.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sample.hibernate.domain.FourWheeler_5_3;
import org.sample.hibernate.domain.TwoWheeler_5_3;
import org.sample.hibernate.domain.Vehicle_5_3;

/***
 * Joined inheritance type.
 * 
 * select * from vehicle_5_3 join twowheeler_5_3 on twowheeler_5_3.VEHICLE_ID =
 * vehicle_5_3.VEHICLE_ID;
 * 
 * @author nagesh_holur
 *
 */
public class main_5_3 {
	public static void main(String[] args) {

		Vehicle_5_3 vehicle = new Vehicle_5_3();
		vehicle.setName("Any Vehicle");

		TwoWheeler_5_3 twoWheeler = new TwoWheeler_5_3();
		twoWheeler.setName("GS150R");
		twoWheeler.setSteeringHandle("Bike Handle");

		FourWheeler_5_3 fourWheeler = new FourWheeler_5_3();
		fourWheeler.setName("Tesla");
		fourWheeler.setSteeringWheel("Tesla steering");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(vehicle);
			session.save(twoWheeler);
			session.save(fourWheeler);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}
}
