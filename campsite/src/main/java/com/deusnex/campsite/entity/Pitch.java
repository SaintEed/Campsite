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
@Table(name = "pitch")
public class Pitch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "booking_id")
	private int bookingId;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@Column(name = "pitch")
	private int pitch;

	@Column(name = "available")
	private String available;

	public Pitch() {

	}

	public Pitch(int id, int bookingId, LocalDate date, int pitch, String available) {
		this.id = id;
		this.bookingId = bookingId;
		this.date = date;
		this.pitch = pitch;
		this.available = available;
	}

	public Pitch(int bookingId, LocalDate date, int pitch, String available) {
		this.bookingId = bookingId;
		this.date = date;
		this.pitch = pitch;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Pitch [id=" + id + ", bookingId=" + bookingId + ", date=" + date + ", pitch=" + pitch + ", available="
				+ available + "]";
	}

}
