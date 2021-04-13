package com.deusnex.campsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.BookingRepository;
import com.deusnex.campsite.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingServiceImpl (BookingRepository theBookingRepository) {
		bookingRepository = theBookingRepository;
	}
	
	@Override
	public List<Booking> findAll() {
				
		return bookingRepository.findAll();
	}
	
	@Override
	
	public List<Booking> findAllByCustId(int theId) {
		
		return bookingRepository.findAllByCustomerId(theId);
	}

	@Override
	public Booking findById(int theId) {
		Optional<Booking> result = bookingRepository.findById(theId);
		
		Booking theBooking = null;
		if (result.isPresent()) {
			theBooking = result.get();
		}else {
			// we didn't find the customer
			throw new RuntimeException("Did not find booking id - " + theId);
		}
		return theBooking;
	}

	@Override
	public void save(Booking theBooking) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}
	

}
