package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.PitchRepository;
import com.deusnex.campsite.entity.Pitch;

@Service
public class PitchServiceImpl implements PitchService {

	private PitchRepository pitchRepository;
	
	@Autowired //@Qualifier used to determine which DAOImpl to use
	public PitchServiceImpl (PitchRepository thePitchRepository) {
		pitchRepository = thePitchRepository;
	}
	
	@Override
	public Pitch RecordBooking(LocalDate theDate, int thePlot, int theBookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pitch DeleteBooking(LocalDate theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pitch> findAvailableByDateBetween(LocalDate start, LocalDate end) {
		return pitchRepository.findAvailableByDateBetween(start, end);
	}

	@Override
	public List<Pitch> findAll() {
		return pitchRepository.findAll();
	}

	@Override
	public void reservePitch(LocalDate start, LocalDate end, int pitch, int bookingId) {
		
		pitchRepository.reservePlot(start, end, pitch, bookingId);
	}

	@Override
	public void unreservePlot(LocalDate start, LocalDate end, int plot) {

		pitchRepository.unreservePlot(start, end, plot);
		
	}

	@Override
	public List<Pitch> findAllOnsite(LocalDate date) {
		return pitchRepository.findAllOnsite(date);
	}

}
