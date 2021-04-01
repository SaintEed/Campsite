package com.deusnex.campsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.deusnex.campsite.dao.CustomerRepository;
import com.deusnex.campsite.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	// Autowire constructor injection
	
	@Autowired
	public CustomerServiceImpl (CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		System.out.println("Got this far");
		return customerRepository.findAll();
	
	}

	@Override
	public Customer findById(int theId) {
		
		return null;
	}

	@Override
	public void save(Customer theCustomer) {
		

	}

	@Override
	public void deleteById(int theId) {
		

	}

}
