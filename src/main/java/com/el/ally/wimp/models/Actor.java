package com.el.ally.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="actor")
public class Actor {

  @Id
  @GeneratedValue
  private int id;

  private String firstName;

  @Column(length=50, nullable=false)
  private String lastName;
  
  @JsonIgnoreProperties("actors")
  @ManyToMany(mappedBy="actors")
  private List<Movie> movies;
  
  public List<Movie> getMovies() {
	return movies;
}
  public void addMovie(Movie movie) {
	  this.movies.add(movie);
  }
@Column(length=250, nullable=false)
  private Date birthdate;

  @Column(updatable=false, nullable=false)
  private Long activeSinceYear;

  @OneToMany(cascade= CascadeType.ALL)
  private List<Award> awards;
  
public List<Award> getAwards() {
	return awards;
}
public void setAwards(List<Award> awards) {
	this.awards = awards;
}
public void addAward(Award award) {
	this.awards.add(award);
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getBirthdate() {
	return birthdate;
}

public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}

public Long getActiveSinceYear() {
	return activeSinceYear;
}

public void setActiveSinceYear(Long activeSinceYear) {
	this.activeSinceYear = activeSinceYear;
}
public Actor() {
	
}
public Actor(String firstName, String lastName, Date birthdate, Long activeSinceYear) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthdate = birthdate;
	this.activeSinceYear = activeSinceYear;
}


 
}
