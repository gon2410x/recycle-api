package com.juy.recycle_api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_department;

	@Column(name = "department_name")
	private String departmentName;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="province")
	private Province province;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Location> locations;
	
	
	
	
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}	
	
	
	
	
	public Long getId_department() {
		return id_department;
	}


	public String getDepartment_name() {
		return departmentName;
	}
	public void setDepartment_name(String department_name) {
		this.departmentName = department_name;
	}
}
