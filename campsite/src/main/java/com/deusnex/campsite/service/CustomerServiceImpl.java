package com.deusnex.campsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusnex.campsite.dao.CustomerRepository;
import com.deusnex.campsite.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

		
		private CustomerRepository customerRepository;
		
		@Autowired //@Qualifier used to determine which DAOImpl to use
		public CustomerServiceImpl (CustomerRepository theCustomerRepository) {
			customerRepository = theCustomerRepository;
		}
		
		@Override
		public List<Customer> findAll() {
			
			return customerRepository.findAllByOrderByLastNameAsc();
		}

		@Override
		public Customer findById(int theId) {
			Optional<Customer> result = customerRepository.findById(theId);
			
			Customer theCustomer = null;
			if (result.isPresent()) {
				theCustomer = result.get();
			}else {
				// we didn't find the customer
				throw new RuntimeException("Did not find customer id - " + theId);
			}
			return theCustomer;
		}

		@Override
		public void save(Customer theCustomer) {
			System.out.println(theCustomer);
			customerRepository.save(theCustomer);
			
		}

		@Override
		public void deleteById(int theId) {
			customerRepository.deleteById(theId);
			
		}
		
	

}