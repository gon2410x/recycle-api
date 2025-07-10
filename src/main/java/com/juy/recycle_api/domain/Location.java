package com.juy.recycle_api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Location {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_location;

	@Column(name = "location_name")
	private String locationName;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department")
	private Department department;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Container> containers;

	// ----- CONTAINERS -----
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Organization> organizations;


	// ----- DEPARTMENT -----
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department departments) {
		this.department = departments;
	}




	// ----- ORGANIZATIONS -----
	public List<Organization> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}



	// ----- PROPERTIES OF THE LOCATION -----
	public Long getId_location() {
		return id_location;
	}
	public void setId_location(Long id_location) {
		this.id_location = id_location;
	}


	public String getLocation_name() {
		return locationName;
	}
	public void setLocation_name(String location_name) {
		this.locationName = location_name;
	}
}
