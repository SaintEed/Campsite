package com.deusnex.campsite.service;

import java.util.List;

import com.deusnex.campsite.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
	public List<Customer> nameSearch(String search);
}
