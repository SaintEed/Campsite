package com.deusnex.campsite.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deusnex.campsite.entity.Customer;
import com.deusnex.campsite.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	// add mapping for list
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the db
		List<Customer> theCustomers = customerService.findAll();
		
		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
		
		
	}
}
