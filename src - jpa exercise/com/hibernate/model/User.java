package com.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User_Details")
public class User {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	// @OneToOne
	/*
	 * @OneToMany
	 * 
	 * @JoinTable(name = "User_vehicle",joinColumns = @JoinColumn(name =
	 * "USER_ID"),inverseJoinColumns =
	 * 
	 * @JoinColumn(name = "vehicle_id"))
	 */
	//@ManyToMany
/*	@OneToMany(cascade = CascadeType.PERSIST)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();  */

	/*
	 * @ElementCollection
	 * 
	 * @JoinTable(name = "User_Address", joinColumns = @JoinColumn(name =
	 * "USER_ID"))
	 * 
	 * @GenericGenerator(name = "increment-gen", strategy = "increment")
	 * 
	 * @CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator =
	 * "increment-gen", type = @Type(type = "long"))
	 * 
	 * private Collection<Address> address = new ArrayList<Address>();
	 */

	// @Embedded
	/*
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "street",column
	 * = @Column(name="HOME_STREET_NAME")),
	 * 
	 * @AttributeOverride(name = "city",column = @Column(name="HOME_CITY_NAME")),
	 * 
	 * @AttributeOverride(name = "state",column = @Column(name="HOME_STATE_NAME")),
	 * 
	 * @AttributeOverride(name = "pincode",column = @Column(name="HOME_PIN_CODE"))
	 * })
	 */

	/*
	 * @ElementCollection
	 * 
	 * @JoinTable(name = "User_Address") private Set<Address> address = new
	 * HashSet<Address>();
	 */
	// @Embedded
	// private Address officeAddress;

	@Temporal(TemporalType.TIME)
	private Date joinedDate;

	/*
	 * public Set<Address> getAddress() { return address; }
	 * 
	 * public void setAddress(Set<Address> address) { this.address = address; }
	 */

	private String description;

	/*
	 * public Vehicle getVehicle() { return vehicle; }
	 * 
	 * public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
	 */

/*	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}   */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	/*
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
