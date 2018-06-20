package com.el.ally.wimp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="award")
public class Award {

  @Id
  @GeneratedValue
   private int id;

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

public String getOrganization() {
	return organization;
}

public void setOrganization(String organization) {
	this.organization = organization;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

@Column(length=500, nullable=false)
  private String title;
  
  @Column(length=200, nullable=false)
  private String organization;
  
  private int year;
}
  