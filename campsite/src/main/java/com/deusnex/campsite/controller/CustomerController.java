package com.deusnex.campsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deusnex.campsite.entity.Customer;
import com.deusnex.campsite.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// add mapping for list
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get employees from the db
		List<Customer> theCustomers = customerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
	}
}
