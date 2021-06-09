package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.deusnex.campsite.entity.Pitch;

public interface PitchService {

	public Pitch RecordBooking(LocalDate theDate, int thePlot, int theBookingId);
	
	public Pitch DeleteBooking(LocalDate theDate, int thePlot);

	public List<Pitch> findAvailableByDateBetween(LocalDate start, LocalDate end);
	
	public List<Pitch> findAllOnsite(LocalDate date);
	
	public void reservePitch(LocalDate start, LocalDate end, int plot, int bookingId);
	
	public void unreservePlot(LocalDate start, LocalDate end, int plot);
	
	public List<Pitch> findAll();
}
