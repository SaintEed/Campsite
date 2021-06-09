package com.deusnex.campsite.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking")
public class Booking {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="pitch")
	private int pitch;
	
	@Column(name="arrival")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivalDate;
	
	@Column(name="last_night")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastNight;
	
	@Column(name="no_nights")
	private int noNights;
	
	@Column(name="dogs")
	private int dogs;
	
	@Column(name="electric")
	private String electric;
	
	@Column(name="fee")
	private int fee;
	
	@Column(name="paid")
	private char paid;
	
	@Column(name="customer_id")
	private int customerId;
	
	//Constructors
	public Booking() {
		
	}

	public Booking(String type, int pitch, LocalDate arrivalDate, LocalDate lastNight, int noNights, String electric, int fee, int customerId) {
		this.type = type;
		this.pitch = pitch;
		this.arrivalDate = arrivalDate;
		this.lastNight = lastNight;
		this.noNights = noNights;
		this.electric = electric;
		this.fee = fee;
		this.customerId = customerId;
	}
	
	

	
	

	public Booking(int id, String type, int pitch, LocalDate arrivalDate, LocalDate lastNight, int noNights, int dogs,
			String electric, int fee, char paid, int customerId) {
		this.id = id;
		this.type = type;
		this.pitch = pitch;
		this.arrivalDate = arrivalDate;
		this.lastNight = lastNight;
		this.noNights = noNights;
		this.dogs = dogs;
		this.electric = electric;
		this.fee = fee;
		this.paid = paid;
		this.customerId = customerId;
	}

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

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getLastNight() {
		return lastNight;
	}

	public void setLastNight(LocalDate lastNight) {
		this.lastNight = lastNight;
	}

	public int getNoNights() {
		return noNights;
	}

	public void setNoNights(int noNights) {
		this.noNights = noNights;
	}

	public int getDogs() {
		return dogs;
	}

	public void setDogs(int dogs) {
		this.dogs = dogs;
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

	public char getPaid() {
		return paid;
	}

	public void setPaid(char paid) {
		this.paid = paid;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", type=" + type + ", pitch=" + pitch + ", arrivalDate=" + arrivalDate
				+ ", lastNight=" + lastNight + ", noNights=" + noNights + ", dogs=" + dogs + ", electric=" + electric
				+ ", fee=" + fee + ", paid=" + paid + ", customerId=" + customerId + "]";
	}


}

	