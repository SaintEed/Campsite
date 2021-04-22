package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.deusnex.campsite.entity.Camp;

public interface CampService {

	public Camp RecordBooking(LocalDate theDate, int thePlot);
	
	public Camp DeleteBooking(LocalDate theDate, int thePlot);

	public List<Camp> findByDateBetween(LocalDate start, LocalDate end);
}
