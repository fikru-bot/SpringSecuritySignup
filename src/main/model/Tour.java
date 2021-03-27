package main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tour {
	
	public enum Continent {
		AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
	}
	
	public Tour() {
		setTourDetails(new TourDetails());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "{tour.name.notblank}")
	@Size(min = 5, message = "{tour.name.size}")
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{tour.code.pattern}")
	private String code;
	private Continent continent;
	
	@NotNull(message = "{tour.date.notnull}")
	@Future(message = "{tour.date.future}")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	
	@Min(value = 7, message = "{tour.duration}")
	@Max(value = 21, message = "{tour.duration}")
	private int duration;
	
	@Column(name = "all_inclusive")
	private boolean allInclusive;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tour_details_id")
	private TourDetails tourDetails;
	
	@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
	private List<Comment> comments;
	

	@ManyToMany
	@JoinTable(name = "tour2user", joinColumns = @JoinColumn(name = "tour_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isAllInclusive() {
		return allInclusive;
	}
	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TourDetails getTourDetails() {
		return tourDetails;
	}
	public void setTourDetails(TourDetails tourDetails) {
		this.tourDetails = tourDetails;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
}
