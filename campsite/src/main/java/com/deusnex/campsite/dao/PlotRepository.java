package com.deusnex.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Integer> {

	@Query(value = "SELECT * FROM campsite.plot WHERE (plot.date BETWEEN ?1 AND ?2) AND plot.available='Y'", nativeQuery = true)
	  List<Plot> findAvailableByDateBetween(LocalDate start, LocalDate end);
}
