package com.deusnex.campsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.AvailableRepository;
import com.deusnex.campsite.entity.Available;

@Service
public class AvailableServiceImpl implements AvailableService {

	private AvailableRepository availableRepository;
	
	@Autowired
	public AvailableServiceImpl (AvailableRepository theAvailableRepository) {
		availableRepository = theAvailableRepository;
	}
	@Override
	public List<Available> FindAvailable(String theArrival, int theNights) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Available RecordBooking(String theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Available DeleteBooking(String theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}

}
