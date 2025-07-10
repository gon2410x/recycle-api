package com.juy.recycle_api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_province;

	@Column(name = "province_name")
	private String provinceName;

	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
	private List<Department> departments;
	
	
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	
	public Long getId_province() {
		return id_province;
	}

	public String getProvince_name() {
		return provinceName;
	}
	public void setProvince_name(String province_name) {
		this.provinceName = province_name;
	}
}
