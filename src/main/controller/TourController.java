package main.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Tour;
import main.service.TourService;

@Controller
public class TourController {
	
	@Autowired
	private TourService tourService;
	
	@GetMapping("/addTour")
	public String showForm(Model model) {
		model.addAttribute("tour", new Tour());
		return "form";
	}
	
	@PostMapping("/processForm")
	public String showTourDate(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		tourService.saveOrUpdate(tour);
		return "redirect:showOffer";
	}
	
	@GetMapping("/showOffer")
	public String getTours(Model model) {
		List<Tour> tours = tourService.getAll();
		model.addAttribute("tours", tours);
		return "tours";
	}
	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable int id) {
		Tour tour = tourService.getById(id);
		if(tour != null) {
			tourService.delete(id);
		}
		return "redirect:/showOffer";
	}
	@GetMapping("/editTour/{id}")
	public String editTour(@PathVariable int id, Model model) {
		Tour tour = tourService.getById(id);
		if(tour != null) {
			model.addAttribute("tour", tour);
			return "form";
			}
		return "redirect:/showOffer";
	}
	@GetMapping("/addUserToTour/{id}")
	public String addUserToTour(@PathVariable int id, Principal principal) {
		tourService.addUserToTour(id, principal.getName());
		return "redirect:/showOffer";
	}
	
	@GetMapping("/showOfferForNextYear")
	public String getToursForNextYear(Model model) {
		List<Tour> tours = tourService.getAllForNextYear();
		model.addAttribute("tours", tours);
		return "tours";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
