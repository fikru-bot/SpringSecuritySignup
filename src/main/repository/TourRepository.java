package main.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer>{

	@Query("from Tour t left join fetch t.comments where t.id = :id")
	public Tour getByIdWithComments(@Param("id") int id);
	
	public List<Tour> findByDateBetween(Date startDate, Date endDate);
}
