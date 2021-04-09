package com.deusnex.campsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// add mapping to show add form
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Customer theCustomer = new Customer();
			
			theModel.addAttribute("customer", theCustomer);
			
			return "customers/customer-form";
		}
		
		@GetMapping("/view")
		public String viewCustomer(@RequestParam("customerId") int theId,
										Model theModel) {
			// get the customer from the service
			Customer theCustomer = customerService.findById(theId);
			
			// set customer as a model atttribute to pre-populate the form
			theModel.addAttribute("customer", theCustomer);
			
			// send over  to our form
			return "customers/customer-view";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int theId,
										Model theModel) {
			// get the employee from the service
			Customer theCustomer = customerService.findById(theId);
			
			// set employee as a model atttribute to pre-populate the form
			theModel.addAttribute("customer", theCustomer);
			
			// send over  to our form
			return "customers/customer-form";
		}
	
		@PostMapping("/save")
		public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
			
			// save the employee
			customerService.save(theCustomer);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/customers/list";
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("customerId") int theId) {
			
			// delete the employee
			customerService.deleteById(theId);
			
			// redirect to /employee/list
			return "redirect:/customers/list";
		}
}
