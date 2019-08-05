package org.sample.hibernate.domain;

import javax.persistence.Entity;

@Entity
public class FourWheeler_5_2 extends Vehicle_5_2 {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
