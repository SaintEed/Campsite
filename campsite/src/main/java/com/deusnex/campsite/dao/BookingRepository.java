package com.deusnex.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Booking;
import com.deusnex.campsite.entity.Plot;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


	List<Booking> findAllByCustomerId(int theId);

	@Query(value = "SELECT * FROM campsite.booking WHERE booking.arrival = ?1", nativeQuery = true)
	List<Booking> findAllByArrivalDate(LocalDate today);

}
