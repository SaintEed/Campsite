package com.deusnex.campsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deusnex.campsite.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// add a method to sort by last name
	
		public List<Customer> findAllByOrderByLastNameAsc();
}
