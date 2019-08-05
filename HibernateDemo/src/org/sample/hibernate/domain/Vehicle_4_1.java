package org.sample.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_4_1")
public class Vehicle_4_1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "vehicles")
	private Collection<UserDetails_4> users = new ArrayList<UserDetails_4>();

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

	public Collection<UserDetails_4> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails_4> users) {
		this.users = users;
	}
	
}
