package com.deusnex.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deusnex.campsite.entity.Pitch;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Integer> {

	@Query(value = "SELECT * FROM campsite.pitch WHERE (pitch.date BETWEEN ?1 AND ?2) AND pitch.available='Y'", nativeQuery = true)
	  List<Pitch> findAvailableByDateBetween(LocalDate start, LocalDate end);
	
	@Query(value = "SELECT * FROM campsite.pitch WHERE pitch.date = ?1 AND pitch.available = 'N' ORDER BY pitch.pitch", nativeQuery = true)
	  List<Pitch> findAllOnsite(LocalDate date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE campsite.pitch SET pitch.available = 'N', pitch.booking_id = ?4 WHERE (pitch.date BETWEEN ?1 AND ?2) AND (pitch.pitch = ?3)", nativeQuery = true)
	  void reservePlot(LocalDate start, LocalDate end, int pitch, int bookingId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE campsite.pitch SET pitch.available = 'Y', pitch.booking_id = 0 WHERE (pitch.date BETWEEN ?1 AND ?2) AND (pitch.pitch = ?3)", nativeQuery = true)
	  void unreservePlot(LocalDate start, LocalDate end, int pitch);
}
