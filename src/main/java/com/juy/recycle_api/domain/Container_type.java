package com.juy.recycle_api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Container_type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_container_type;
	private String residuo;
	private String color;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="container_type")
//	@JsonManagedReference
	@JsonIgnore
	private List<Container> containers;
	
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
	 
	
	
	public Long getId_container_type() {
		return id_container_type;
	}
	public void setId_container_type(Long id_container_type) {
		this.id_container_type = id_container_type;
	}

	public String getResiduo() {
		return residuo;
	}
	public void setResiduo(String residuo) {
		this.residuo = residuo;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
