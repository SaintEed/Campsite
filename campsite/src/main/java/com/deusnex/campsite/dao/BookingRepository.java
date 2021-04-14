package com.deusnex.campsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


	List<Booking> findAllByCustomerId(int theId);

}