package com.deusnex.campsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findAllByOrderByLastNameAsc();
}
