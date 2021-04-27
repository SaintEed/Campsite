package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.deusnex.campsite.entity.Plot;

public interface PlotService {

	public Plot RecordBooking(LocalDate theDate, int thePlot, int theBookingId);
	
	public Plot DeleteBooking(LocalDate theDate, int thePlot);

	public List<Plot> findAvailableByDateBetween(LocalDate start, LocalDate end);
	
	public List<Plot> findAll();
}
