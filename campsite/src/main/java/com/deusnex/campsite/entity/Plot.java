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
@Table(name="plot")
public class Plot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name="plot")
	private int plot;
	
	@Column(name="available")
	private String available;
	
	@Column(name="booking_id")
	private int bookingId;
	
	public Plot () {
		
	}

	public Plot(int id, LocalDate date, int plot, String available, int bookingId) {
		this.id = id;
		this.date = date;
		this.plot = plot;
		this.available = available;
		this.bookingId = bookingId;
	}

	public Plot(LocalDate date, int plot, String available, int bookingId) {
		this.date = date;
		this.plot = plot;
		this.available = available;
		this.bookingId = bookingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPlot() {
		return plot;
	}

	public void setPlot(int plot) {
		this.plot = plot;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Plot [id=" + id + ", date=" + date + ", plot=" + plot + ", available=" + available + ", bookingId="
				+ bookingId + "]";
	}
	
	
}
