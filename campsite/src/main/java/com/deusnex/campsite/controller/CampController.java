package com.deusnex.campsite.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deusnex.campsite.AvailabilityCheck;
import com.deusnex.campsite.entity.Camp;
import com.deusnex.campsite.service.CampService;
import com.deusnex.campsite.service.BookingService;
import com.deusnex.campsite.service.CustomerService;

@Controller
@RequestMapping("/camp")
public class CampController {

	@Autowired
	private CampService campService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showCheckForm")
	public String showCheckForm(Model theModel) {
	
		AvailabilityCheck theCheck = new AvailabilityCheck();

		theModel.addAttribute("check", theCheck);
		
		// send over  to our form
		return "camp/checkForm";
	}
	
	@PostMapping("/runCheck")
	public String runCheck(@ModelAttribute("check") AvailabilityCheck theCheck) {
		
		System.out.println(theCheck);		
		
		//Define result set
		
		//@SuppressWarnings("unused")
		List<Camp> resultSet = new ArrayList<>();
		
		
		resultSet = campService.findByDateBetween(theCheck.getStartDate(), theCheck.getEndDate());
		
		for (Camp temp : resultSet) {
			System.out.println(temp.toString());
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}
}
