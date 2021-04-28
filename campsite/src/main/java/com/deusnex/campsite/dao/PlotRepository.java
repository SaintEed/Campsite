package com.deusnex.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deusnex.campsite.entity.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Integer> {

	@Query(value = "SELECT * FROM campsite.plot WHERE (plot.date BETWEEN ?1 AND ?2) AND plot.available='Y'", nativeQuery = true)
	  List<Plot> findAvailableByDateBetween(LocalDate start, LocalDate end);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE campsite.plot SET plot.available = 'N', plot.booking_id = ?4 WHERE (plot.date BETWEEN ?1 AND ?2) AND (plot.plot = ?3)", nativeQuery = true)
	  void reservePlot(LocalDate start, LocalDate end, int plot, int bookingId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE campsite.plot SET plot.available = 'Y', plot.booking_id = 0 WHERE (plot.date BETWEEN ?1 AND ?2) AND (plot.plot = ?3)", nativeQuery = true)
	  void unreservePlot(LocalDate start, LocalDate end, int plot);
}
