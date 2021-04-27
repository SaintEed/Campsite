package com.deusnex.campsite.controller;

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
import com.deusnex.campsite.entity.Plot;
import com.deusnex.campsite.service.PlotService;

@Controller
@RequestMapping("/plot")
public class PlotController {

	
	@Autowired
	private PlotService plotService;
	
	
	@GetMapping("/showCheckForm")
	public String showCheckForm(Model theModel) {
	
		AvailabilityCheck theCheck = new AvailabilityCheck();

		theModel.addAttribute("check", theCheck);
		
		// send over  to our form
		return "plot/checkForm";
	}
	
	@PostMapping("/runCheck")
	public String runCheck(@ModelAttribute("check") AvailabilityCheck theCheck) {
		
		List<String> checkOutput = new ArrayList<>();
		int x = 0;
		int days = theCheck.getNoNights();
		int count;
		
		List<Plot> resultSet = new ArrayList<>();
		

		resultSet = plotService.findAvailableByDateBetween(theCheck.getStartDate(), theCheck.getEndDate());
		
		switch (theCheck.getType()) {
		case "Static":
			count = 0;
			x = 11;
			for (Plot temp : resultSet) {
					if (temp.getPlot() == x) {
						count++;
					}
				}
			
			if (count < days) {
				checkOutput.add("Fully Booked");
			}else {
				checkOutput.add("Plot 11");
			}
			break;
		
		case "Pod":
			count = 0;
			x = 12;
			for (Plot temp : resultSet) {
					if (temp.getPlot() == x) {
						count++;
					}
				}
			
			if (count < days) {
				checkOutput.add("Fully Booked");
			}else {
				checkOutput.add("Plot 12");
			}
			break;
		
		default:
			for(int y = 1; y < 11; y++) {
				count = 0;
				for (Plot temp : resultSet) {
					if (temp.getPlot() == y) {
						count++;
					}
				}
				if ((count > days)|(count != 0)) {
					checkOutput.add("Plot " + y);
				}
			}
			break;
		}
		for (String temp : checkOutput) {
			System.out.println(temp.toString());
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
		}
	
	}




