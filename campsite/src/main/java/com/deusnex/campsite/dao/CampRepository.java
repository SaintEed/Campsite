package com.deusnex.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Camp;

@Repository
public interface CampRepository extends JpaRepository<Camp, LocalDate> {

	@Query(value = "SELECT * FROM campsite.camp WHERE camp.date BETWEEN ?1 AND ?2 ", nativeQuery = true)
	  List<Camp> findByDateBetween(LocalDate start, LocalDate end);
	 
}
