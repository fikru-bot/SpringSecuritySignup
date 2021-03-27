package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Comment;
import main.model.Tour;
import main.service.CommentService;
import main.service.TourService;

@Controller
public class CommentController {
	
	@Autowired
	private TourService tourService;
	
	@Autowired
	private CommentService commentService;

	@GetMapping("/addComment")
	public String showCommentForm(Model model) {
		List<Tour> tours = tourService.getAll();
		model.addAttribute("tours", tours);
		model.addAttribute("comment", new Comment());
		return "form-comment";
	}
	
	@PostMapping("/processFormComment")
	public String addCommentData(@ModelAttribute Comment comment) {
		commentService.save(comment);
		return "home";
	}
}
