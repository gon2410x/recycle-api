package com.juy.recycle_api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_container;

	private String longitude;
	private String latitude;
	private String street_description;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="container_type")
//	@JsonBackReference
	private Container_type container_type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="location")
	private Location location;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organization")
	private Organization organization;
	
	
	
	public Container_type getContainer_type() {
		return container_type;
	}
	public void setContainer_type(Container_type container_type) {
		this.container_type = container_type;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	
	public Long getId_container() {
		return id_container;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getStreet_description() {
		return street_description;
	}
	public void setStreet_description(String street_description) {
		this.street_description = street_description;
	}
}
