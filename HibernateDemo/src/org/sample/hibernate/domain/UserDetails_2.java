package org.sample.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_2")
public class UserDetails_2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "ADDRESSES_2_1", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address_2> addresses1 = new ArrayList<Address_2>();

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

	public Collection<Address_2> getAddresses1() {
		return addresses1;
	}

	public void setAddresses1(Collection<Address_2> addresses1) {
		this.addresses1 = addresses1;
	}

}
