package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Tour;
import main.model.TourDetails;
import main.service.TourDetailsService;
import main.service.TourService;

@Controller
public class TourDetailsController {
	
	@Autowired
	private TourService tourService;
	@Autowired
	private TourDetailsService tourDetailsService;
	
	@GetMapping("/showTourDetails/{tourId}")
	public String showTourDetails(@PathVariable int tourId, Model model) {
		Tour tour = tourService.getByIdWithComments(tourId);
		if(tour != null) {
			model.addAttribute("tour", tour);
			return "tour-details";
		}
		
		return "redirect:/showOffer"; 
	}

	@GetMapping("/editTourDetails/{tourId}")
	public String editTourDetails(@PathVariable int tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if(tour != null) {
			model.addAttribute("tourDetails", tour.getTourDetails());
			return "form-tour-details";
		}
		
		return "redirect:/showOffer ";
	}
	@PostMapping("/processFormTourDetails")
	public String processFormTourDetails(@ModelAttribute TourDetails tourDetails) {
		tourDetailsService.saveOrUpdate(tourDetails);
		return "redirect:/showOffer";
	}
	
	
	
	
}
