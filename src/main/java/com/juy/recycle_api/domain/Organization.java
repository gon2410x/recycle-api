package com.juy.recycle_api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Organization {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_organization;

	private String organization_name;
	private String phone;
	private String email;
	private String organization_type;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location")
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
	private List<Container> containers;

	// ----- CONTAINERS -----
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}


	public Long getId_organization() {
		return id_organization;
	}
	public void setId_organization(Long id_organization) {
		this.id_organization = id_organization;
	}

	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization_type() {
		return organization_type;
	}
	public void setOrganization_type(String organization_type) {
		this.organization_type = organization_type;
	}
}
