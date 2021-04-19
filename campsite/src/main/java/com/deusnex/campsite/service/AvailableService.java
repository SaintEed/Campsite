package com.deusnex.campsite.service;

import java.util.List;

import com.deusnex.campsite.entity.Available;

public interface AvailableService {

	public List<Available> FindAvailable(String theArrival, int theNights);
	
	public Available RecordBooking(String theDate, int thePlot);
	
	public Available DeleteBooking(String theDate, int thePlot);
}
