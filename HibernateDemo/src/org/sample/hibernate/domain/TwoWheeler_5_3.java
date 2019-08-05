package org.sample.hibernate.domain;

import javax.persistence.Entity;

@Entity 
public class TwoWheeler_5_3 extends Vehicle_5_3 {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
