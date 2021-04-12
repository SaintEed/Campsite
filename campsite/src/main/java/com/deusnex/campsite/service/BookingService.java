package com.deusnex.campsite.service;

import java.util.List;

import com.deusnex.campsite.entity.Booking;

public interface BookingService {

	public List<Booking> findAll();
	
	public List<Booking> findAllByCustId(int theId);
	
	public Booking findById(int theId);
	
	public void save(Booking theBooking);
	
	public void deleteById(int theId);
}
