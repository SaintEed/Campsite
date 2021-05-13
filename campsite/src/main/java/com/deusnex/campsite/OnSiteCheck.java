package com.deusnex.campsite;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class OnSiteCheck {
	
	private String firstName;
	
	private String lastName;
	
	private int pitch;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivalDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastNight;
	
	public OnSiteCheck() {
		
	}

	public OnSiteCheck(String firstName, String lastName, int pitch, LocalDate arrivalDate, LocalDate lastNight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pitch = pitch;
		this.arrivalDate = arrivalDate;
		this.lastNight = lastNight;
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

	@Override
	public String toString() {
		return "OnSiteCheck [firstName=" + firstName + ", lastName=" + lastName + ", pitch=" + pitch + ", arrivalDate="
				+ arrivalDate + ", lastNight=" + lastNight + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
