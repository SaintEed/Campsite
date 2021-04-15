package com.deusnex.campsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="plot")
	private String plot;
	
	@Column(name="arrival")
	private String arrivalDate;
	
	@Column(name="no_nights")
	private int noNights;
	
	@Column(name="electric")
	private String electric;
	
	@Column(name="fee")
	private int fee;
	
	@Column(name="customer_id")
	private int customerId;
	
	//Constructors
	public Booking() {
		
	}

	public Booking(String type, String plot, String arrivalDate, int noNights, String electric, int fee, int customerId) {
		this.type = type;
		this.plot = plot;
		this.arrivalDate = arrivalDate;
		this.noNights = noNights;
		this.electric = electric;
		this.fee = fee;
		this.customerId = customerId;
	}
	
	

	
	
	public Booking(int id, String type, String plot, String arrivalDate, int noNights, String electric, int fee,
			int customerId) {
		this.id = id;
		this.type = type;
		this.plot = plot;
		this.arrivalDate = arrivalDate;
		this.noNights = noNights;
		this.electric = electric;
		this.fee = fee;
		this.customerId = customerId;
	}

	// Getters/Setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getNoNights() {
		return noNights;
	}

	public void setNoNights(int noNights) {
		this.noNights = noNights;
	}

	public String getElectric() {
		return electric;
	}

	public void setElectric(String electric) {
		this.electric = electric;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", type=" + type + ", plot=" + plot + ", arrivalDate=" + arrivalDate
				+ ", noNights=" + noNights + ", electric=" + electric + ", fee=" + fee + ", customerId=" + customerId
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

	