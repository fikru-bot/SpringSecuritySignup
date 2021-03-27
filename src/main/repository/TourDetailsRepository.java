package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.TourDetails;

@Repository
public interface TourDetailsRepository extends JpaRepository<TourDetails, Integer> {

}
