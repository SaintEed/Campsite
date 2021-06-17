package com.deusnex.campsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findAllByOrderByLastNameAsc();
	
	@Query(value = "SELECT * FROM campsite.customer WHERE customer.last_name LIKE CONCAT ('%', ?1, '%') OR customer.first_name LIKE CONCAT ('%', ?1, '%')", nativeQuery = true)
	List<Customer> findBySearch(String search);
}
