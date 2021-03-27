package main.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Tour;
import main.model.User;
import main.repository.TourRepository;
import main.repository.UserRepository;
@Service
@Transactional
public class TourServiceImpl implements TourService{

	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Tour> getAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(int id) {
		return tourRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourRepository.save(tour);
	}

	@Override
	public void delete(int id) {
		tourRepository.deleteById(id);
		
	}

	@Override
	public Tour getByIdWithComments(int id) {
		return tourRepository.getByIdWithComments(id);
	}

	@Override
	public void addUserToTour(int id, String login) {
		Tour tour = getById(id);
		if(tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		
		User user = userRepository.findByLogin(login);
		if(user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
		
	}

	@Override
	public List<Tour> getAllForNextYear() {
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, 1);
		return tourRepository.findByDateBetween(currentDate, calendar.getTime());
	}

	

}
