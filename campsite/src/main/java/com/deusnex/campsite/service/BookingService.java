package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.deusnex.campsite.entity.Booking;

public interface BookingService {

	public List<Booking> findAll();
	
	public List<Booking> findAllByCustId(int theId);
	
	public Booking findById(int theId);
	
	public List<Booking> findAllByArrivalDate(LocalDate today);
	
	public void save(Booking theBooking);
	
	public void deleteById(int theId);
}
