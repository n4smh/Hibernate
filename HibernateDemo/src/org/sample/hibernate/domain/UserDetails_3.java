package org.sample.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_3")
public class UserDetails_3 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	// Inserts VEHICLE_ID column in USER_DETAILS_3 table itself. Doesn't creates
	// new table. VEHICLE_ID of this table refers to Vehicle_3 tables Primary
	// key (VEHICLE_ID).
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle_3_1 vehicle;

	// Creates new table to map USER_DETAILS_3 to Vehicle_3_2. Primary key
	// mappings. USER_ID - VEHICLE_ID. Table name can also be configured.
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Collection<Vehicle_3_2> vehicles1 = new ArrayList<Vehicle_3_2>();

	// This is to access VEHICLE_3_3 from USER_DETAILS_3 and USER_DETAILS_3 from
	// VEHICLE_3_3. Maps to column user (UserDetails_3) in VEHICLE_3_3 table. No
	// new table is created for mapping.
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "user")
	private Collection<Vehicle_3_3> vehicles2 = new ArrayList<Vehicle_3_3>();

	// Many users referring to same address. No new table is created
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address_3 address_3 = new Address_3();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle_3_1 getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle_3_1 vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Vehicle_3_2> getVehicles1() {
		return vehicles1;
	}

	public void setVehicles1(Collection<Vehicle_3_2> vehicles1) {
		this.vehicles1 = vehicles1;
	}

	public Collection<Vehicle_3_3> getVehicles2() {
		return vehicles2;
	}

	public void setVehicles2(Collection<Vehicle_3_3> vehicles2) {
		this.vehicles2 = vehicles2;
	}

	public Address_3 getAddress_3() {
		return address_3;
	}

	public void setAddress_3(Address_3 address_3) {
		this.address_3 = address_3;
	}

}
