package com.deusnex.campsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deusnex.campsite.entity.Booking;
import com.deusnex.campsite.service.BookingService;
import com.deusnex.campsite.service.PlotService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PlotService plotService;
	
	
	@GetMapping("/showBookingFormForAdd")
	public String showBookingFormForAdd(@RequestParam("customerId") int custId, Model theModel) {
		
		
		// create model attribute to bind form data
		Booking theBooking = new Booking();
		
		//theBooking.setCustomerId(theId);
		theBooking.setCustomerId(custId);
		
		theModel.addAttribute("booking", theBooking);
		
		return "bookings/booking-form";
	}
	
	@GetMapping("/showBookingFormForUpdate")
	public String showBookingFormForUpdate(@RequestParam("bookingId") int theId,
									Model theModel) {
		// get the employee from the service
		Booking theBooking = bookingService.findById(theId);
		
		// set employee as a model atttribute to pre-populate the form
		theModel.addAttribute("booking", theBooking);
		
		// send over  to our form
		return "bookings/booking-form";
	}
	
	@PostMapping("/save")
	public String saveBooking(@ModelAttribute("booking") Booking theBooking) {
		
		//Calculate fee
		switch (theBooking.getType()) {
		case "Caravan":
			theBooking.setFee(theBooking.getNoNights() * 18);
			break;
		case "Tent":
			theBooking.setFee(theBooking.getNoNights() * 18);
			break;
		case "Motorhome":
			theBooking.setFee(theBooking.getNoNights() * 18);
			break;
		case "Static":
			theBooking.setFee(theBooking.getNoNights() * 65);
			break;
		case "Pod":
			theBooking.setFee(theBooking.getNoNights() * 45);
			break;
		}
				
		//save the booking
		bookingService.save(theBooking);
		
		//reserve the plot
		
		plotService.reservePlot(theBooking.getArrivalDate(), theBooking.getLastNight(), theBooking.getPlot(), theBooking.getCustomerId());
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookingId") int theId) {
		
		//FInd the booking to be deleted
		Booking theBooking = new Booking();
		theBooking = bookingService.findById(theId);
		
		//unreserve the plot
		plotService.unreservePlot(theBooking.getArrivalDate(), theBooking.getLastNight(), theBooking.getPlot());
		
		// delete the booking
		bookingService.deleteById(theId);
		
		
		
		// redirect to /employee/list
		return "redirect:/customers/list";
	}

}
