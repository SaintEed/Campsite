package com.deusnex.campsite.service;

import java.util.List;

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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(Customer theCustomer) {
			customerRepository.save(theCustomer);
			
		}

		@Override
		public void deleteById(int theId) {
			// TODO Auto-generated method stub
			
		}
		
	

}
