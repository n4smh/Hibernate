package org.sample.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
// Uses HQL, later converted to SQL by Hibernate.
@NamedQuery(name = "UserDetails_7_1.byId", query = "from UserDetails_7_1 where id >= :id and name = :name")
// Uses SQL
@NamedNativeQuery(name = "UserDetails_7_1.byIdNativeSQL", query = "select * from USER_DETAILS_7_1 where USER_ID >= :id and NAME = :name", resultClass = UserDetails_7_1.class)
@Table(name = "USER_DETAILS_7_1")
public class UserDetails_7_1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PLACE")
	private String place;

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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
