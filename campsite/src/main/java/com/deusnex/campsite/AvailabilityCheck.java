package com.deusnex.campsite;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AvailabilityCheck {

	private String type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	private int noNights;
	
	public AvailabilityCheck() {
		
	}


	public AvailabilityCheck(String type, LocalDate startDate, LocalDate endDate, int noNights) {
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noNights = noNights;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public int getNoNights() {
		return noNights;
	}


	public void setNoNights(int noNights) {
		this.noNights = noNights;
	}


	@Override
	public String toString() {
		return "AvailabilityCheck [type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + ", noNights="
				+ noNights + "]";
	}
	
	


	

	
}
