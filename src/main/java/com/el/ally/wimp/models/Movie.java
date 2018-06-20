package com.el.ally.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movie")
public class Movie {

  @Id
  @GeneratedValue
   private int id;

  @Column(length=300, nullable=false)
  private String title;
  
  @JsonIgnoreProperties("movies")
  @ManyToMany
  private List<Actor> actors;
  
  private Date releaseDate;

  public List<Actor> getActors() {
	return actors;
}
  public void addActor(Actor actor) {
	  this.actors.add(actor);
  }
  
private Long budget;

  @Column(length=500, nullable=false)
  private String distributor;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Date getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}

public Long getBudget() {
	return budget;
}

public void setBudget(Long budget) {
	this.budget = budget;
}

public String getDistributor() {
	return distributor;
}

public void setDistributor(String distributor) {
	this.distributor = distributor;
}

public Movie() {
	
}
public Movie(String title, Date releaseDate, Long budget, String distributor) {
	this.title = title;
	this.releaseDate = releaseDate;
	this.budget = budget;
	this.distributor = distributor;
}

 

}
