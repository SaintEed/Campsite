package com.deusnex.campsite;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AvailabilityCheck {

	private String type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	public AvailabilityCheck() {
		
	}


	public AvailabilityCheck(String type, LocalDate startDate, LocalDate endDate) {
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
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


	@Override
	public String toString() {
		return "AvailabilityCheck [type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
}
