package com.deusnex.campsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postcode")
	private String postcode;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="email")
	private String email;
	
	/*
	 * @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="customer_id") private List<Booking> bookings;
	 */
	
	// Constructors
	public Customer() {
		
	}


	public Customer(String firstName, String lastName, String streetAddress, String city, String contactNo, String postcode,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.postcode = postcode;
		this.contactNo = contactNo;
		this.email = email;
	}


	public Customer(int id, String firstName, String lastName, String streetAddress, String city, String postcode,
			String contactNo, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.postcode = postcode;
		this.contactNo = contactNo;
		this.email = email;
	}


	// Getters/Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	
	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress="
				+ streetAddress + ", city=" + city + ", postcode=" + postcode + ", contactNo=" + contactNo + ", email="
				+ email + "]";
	}


	
	
}
