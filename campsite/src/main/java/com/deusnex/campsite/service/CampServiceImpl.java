package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.CampRepository;
import com.deusnex.campsite.entity.Camp;

@Service
public class CampServiceImpl implements CampService {

	private CampRepository campRepository;
	
	@Autowired
	public CampServiceImpl (CampRepository theAvailableRepository) {
		campRepository = theAvailableRepository;
	}


	@Override
	public Camp DeleteBooking(LocalDate theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Camp> findByDateBetween(LocalDate start, LocalDate end) {
		System.out.println(start);
		System.out.println(end);
		return campRepository.findByDateBetween(start, end);
	}


	@Override
	public Camp RecordBooking(LocalDate theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
