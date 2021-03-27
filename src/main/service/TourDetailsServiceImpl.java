package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.TourDetails;
import main.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService{
	
	@Autowired
	private TourDetailsRepository tourDetailsRepository;

	@Override
	public TourDetails getById(int id) {
		return tourDetailsRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		tourDetailsRepository.save(tourDetails);
		
	}

	@Override
	public void delete(int id) {
		tourDetailsRepository.deleteById(id);
		
	}

}
