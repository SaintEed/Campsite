package com.deusnex.campsite.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.PlotRepository;
import com.deusnex.campsite.entity.Plot;

@Service
public class PlotServiceImpl implements PlotService {

	private PlotRepository plotRepository;
	
	@Autowired //@Qualifier used to determine which DAOImpl to use
	public PlotServiceImpl (PlotRepository thePlotRepository) {
		plotRepository = thePlotRepository;
	}
	
	@Override
	public Plot RecordBooking(LocalDate theDate, int thePlot, int theBookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plot DeleteBooking(LocalDate theDate, int thePlot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plot> findAvailableByDateBetween(LocalDate start, LocalDate end) {
		return plotRepository.findAvailableByDateBetween(start, end);
	}

	@Override
	public List<Plot> findAll() {
		return plotRepository.findAll();
	}

}
