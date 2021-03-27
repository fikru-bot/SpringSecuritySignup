package main.service;

import java.util.List;

import main.model.Tour;

public interface TourService {
	
    public List<Tour> getAll();
	
	public Tour getById(int id);
	
	public void saveOrUpdate(Tour tour);
	
	public void delete(int id);
	
	public Tour getByIdWithComments(int id);
	
	public void addUserToTour(int id, String login);
	
	public List<Tour> getAllForNextYear();

}
