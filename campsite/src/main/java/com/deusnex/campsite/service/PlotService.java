package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.deusnex.campsite.entity.Plot;

public interface PlotService {

	public Plot RecordBooking(LocalDate theDate, int thePlot, int theBookingId);
	
	public Plot DeleteBooking(LocalDate theDate, int thePlot);

	public List<Plot> findAvailableByDateBetween(LocalDate start, LocalDate end);
	
	public List<Plot> findAllOnsite(LocalDate date);
	
	public void reservePlot(LocalDate start, LocalDate end, int plot, int bookingId);
	
	public void unreservePlot(LocalDate start, LocalDate end, int plot);
	
	public List<Plot> findAll();
}
