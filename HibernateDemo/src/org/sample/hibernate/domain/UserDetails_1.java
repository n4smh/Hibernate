package org.sample.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS_1")
public class UserDetails_1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "RUN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;

	// Column is not create in table for transient
	@Transient
	private String className;

	// No new table is created. Members of Address class are inserted into this
	// class table as if they are members of this class
	@Embedded
	private Address_1 address;

	// Overriding column name of embedded class members
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")) })
	private Address_1 homeAddress;

	@ElementCollection
	@JoinTable(name = "ADDRESSES_1_1", joinColumns = @JoinColumn(name = "USER_ID"))
	private Set<Address_1> addresses1 = new HashSet<Address_1>();

	// @GenericGenerator & @CollectionId are hibernate specific. These are not
	// JPA standard.
	@ElementCollection
	@JoinTable(name = "ADDRESSES_1_2", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type = "long"))
	private Collection<Address_1> addresses2 = new ArrayList<Address_1>();

	// Large character or byte stream object
	@Column(name = "DESCRIPTION")
	@Lob
	private String description;

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

	public Address_1 getAddress() {
		return address;
	}

	public void setAddress(Address_1 address) {
		this.address = address;
	}

	public Address_1 getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address_1 homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Address_1> getAddresses1() {
		return addresses1;
	}

	public void setAddresses1(Set<Address_1> addresses1) {
		this.addresses1 = addresses1;
	}

	public Collection<Address_1> getAddresses2() {
		return addresses2;
	}

	public void setAddresses2(Collection<Address_1> addresses2) {
		this.addresses2 = addresses2;
	}

}
