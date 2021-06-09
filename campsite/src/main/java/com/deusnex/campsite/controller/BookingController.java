package com.deusnex.campsite.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deusnex.campsite.ArrivalCheck;
import com.deusnex.campsite.AvailabilityCheck;
import com.deusnex.campsite.OnSiteCheck;
import com.deusnex.campsite.entity.Booking;
import com.deusnex.campsite.entity.Customer;
import com.deusnex.campsite.entity.Pitch;
import com.deusnex.campsite.service.BookingService;
import com.deusnex.campsite.service.CustomerService;
import com.deusnex.campsite.service.PitchService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

	@Value("${fee.caravan}")
	private int caravan;

	@Value("${fee.tent}")
	private int tent;

	@Value("${fee.static}")
	private int staticFee;

	@Value("${fee.pod}")
	private int pod;

	@Value("${fee.dog}")
	private int dog;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private PitchService pitchService;

	@GetMapping("/showBookingFormForAdd")
	public String showBookingFormForAdd(@RequestParam("customerId") int custId, Model theModel) {

		// create model attribute to bind form data
		Booking theBooking = new Booking();

		// theBooking.setCustomerId(theId);
		theBooking.setCustomerId(custId);

		theModel.addAttribute("booking", theBooking);

		return "bookings/booking-form";
	}

	@GetMapping("/showBookingFormForUpdate")
	public String showBookingFormForUpdate(@RequestParam("bookingId") int theId, Model theModel) {
		// get the employee from the service
		Booking theBooking = bookingService.findById(theId);

		// set employee as a model atttribute to pre-populate the form
		theModel.addAttribute("booking", theBooking);

		bookingService.deleteById(theId);
		pitchService.unreservePlot(theBooking.getArrivalDate(),
				theBooking.getLastNight(), theBooking.getPitch());

		// send over to our form
		return "bookings/booking-form";
	}

	@RequestMapping(value = "/makeBooking", params = "action=check", method = RequestMethod.POST)
	public String runCheck(@ModelAttribute("booking") Booking theBooking, Model theModel) {

		theModel.addAttribute("booking", theBooking);

		AvailabilityCheck theCheck = new AvailabilityCheck();

		theCheck.setType(theBooking.getType());
		theCheck.setStartDate(theBooking.getArrivalDate());
		theCheck.setEndDate(theBooking.getLastNight());
		theCheck.setNoNights(theBooking.getNoNights());

		List<String> checkOutput = new ArrayList<>();
		int x = 0;
		int count;
		int days = theCheck.getNoNights();

		List<Pitch> resultSet = new ArrayList<>();

		resultSet = pitchService.findAvailableByDateBetween(theCheck.getStartDate(), theCheck.getEndDate());

		switch (theCheck.getType()) {
		case "Static":
			count = 0;
			x = 11;
			for (Pitch temp : resultSet) {
				if (temp.getPitch() == x) {
					count++;
				}
			}

			if (count < days) {
				checkOutput.add("Fully Booked");
			} else {
				checkOutput.add("Pitch 11");
			}
			break;

		case "Pod":
			count = 0;
			x = 12;
			for (Pitch temp : resultSet) {
				if (temp.getPitch() == x) {
					count++;
				}
			}

			if (count < days) {
				checkOutput.add("Fully Booked");
			} else {
				checkOutput.add("Pitch 12");
			}
			break;

		case "Tent":
			for (int y = 1; y < 6; y++) {
				count = 0;
				for (Pitch temp : resultSet) {
					if (temp.getPitch() == y) {
						count++;
					}
				}
				if (!(count < days)) {
					checkOutput.add("Pitch " + y);
				}
			}
			break;
			
		default: 
			for (int y = 1; y < 11; y++) {
				count = 0;
				for (Pitch temp : resultSet) {
					if (temp.getPitch() == y) {
						count++;
					}
				}
				if (!(count < days)) {
					checkOutput.add("Pitch " + y);
				}
			}
			break;
		}

		// add to the spring model
		theModel.addAttribute("checkOutput", checkOutput);

		// use a redirect to prevent duplicate submissions
		return "pitch/checkResults";
	}

	@RequestMapping(value = "/makeBooking", params = "action=save", method = RequestMethod.POST)
	public String saveBooking(@ModelAttribute("booking") Booking theBooking, Model theModel) {

		// Calculate fee

		switch (theBooking.getType()) {
		case "Caravan":
			theBooking.setFee(theBooking.getNoNights() * caravan);
			break;
		case "Tent":
			theBooking.setFee(theBooking.getNoNights() * tent);
			break;
		case "Motorhome":
			theBooking.setFee(theBooking.getNoNights() * caravan);
			break;
		case "Static":
			theBooking.setFee(theBooking.getNoNights() * staticFee);
			break;
		case "Pod":
			theBooking.setFee(theBooking.getNoNights() * pod);
			break;
		}

		if (theBooking.getDogs() > 0) {
			int dogsFee = 0;
			dogsFee = (theBooking.getDogs() * theBooking.getNoNights());
			dogsFee = dogsFee * dog;
			theBooking.setFee(theBooking.getFee() + dogsFee);
		}
		
		bookingService.save(theBooking);

		pitchService.reservePitch(theBooking.getArrivalDate(), theBooking.getLastNight(), theBooking.getPitch(),
				theBooking.getId());
		
		//get customer  and booking data for transfer to customer view
		Customer theCustomer = new Customer();
		theCustomer = customerService.findById(theBooking.getCustomerId());
		theModel.addAttribute("customer", theCustomer);
		
		List<Booking> theBookings = bookingService.findAllByCustId(theBooking.getCustomerId());
		theModel.addAttribute("bookings", theBookings);

		return "customers/customer-view";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("bookingId") int theId, Model theModel) {

		// FInd the booking to be deleted
		Booking theBooking = new Booking();
		theBooking = bookingService.findById(theId);

		// unreserve the plot
		pitchService.unreservePlot(theBooking.getArrivalDate(), theBooking.getLastNight(), theBooking.getPitch());

		// delete the booking
		bookingService.deleteById(theId);
		
		//prepare data for transfer to customer view
		Customer theCustomer = new Customer();
		theCustomer = customerService.findById(theBooking.getCustomerId());
		theModel.addAttribute("customer", theCustomer);
		
		List<Booking> theBookings = bookingService.findAllByCustId(theBooking.getCustomerId());
		theModel.addAttribute("bookings", theBookings);

		return "customers/customer-view";
	}

	@GetMapping("/arrivalsToday")
	public String arrivalToday(Model theModel) {

		List<Booking> theBookingSet = new ArrayList<>();

		List<ArrivalCheck> arrivals = new ArrayList<>();

		LocalDate today;

		today = java.time.LocalDate.now();

		theBookingSet = bookingService.findAllByArrivalDate(today);

		for (Booking temp : theBookingSet) {
			Customer scratch;
			scratch = customerService.findById(temp.getCustomerId());
			ArrivalCheck check = new ArrivalCheck(scratch.getLastName(), temp.getType(), temp.getPitch(), temp.getNoNights(), temp.getFee(), temp.getPaid());
			arrivals.add(check);
		}

		// add to the spring model
		theModel.addAttribute("arrivals", arrivals);

		return "bookings/arrivals";

	}
	
	@GetMapping("/siteStatus")
	public String siteStatus(Model theModel) {

		
		List<Pitch> theCampSet = new ArrayList<>();
		
		List<OnSiteCheck> resultSet = new ArrayList<>();

		LocalDate today;

		today = java.time.LocalDate.now();
		
		theCampSet = pitchService.findAllOnsite(today);


		for (Pitch temp : theCampSet) {
			
			Booking theBooking = bookingService.findById(temp.getBookingId());
			Customer theCustomer = customerService.findById(theBooking.getCustomerId());
			OnSiteCheck scratch = new OnSiteCheck(theCustomer.getFirstName(), theCustomer.getLastName(), theBooking.getPitch(), theBooking.getArrivalDate(), theBooking.getLastNight());
			resultSet.add(scratch);
		}

		// add to the spring model
		theModel.addAttribute("resultSet", resultSet);

		return "bookings/onSiteResults";

	}

}
