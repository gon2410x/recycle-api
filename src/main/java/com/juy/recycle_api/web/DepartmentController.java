package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Department;
import com.juy.recycle_api.domain.DepartmentRepository;
import com.juy.recycle_api.domain.Province;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DepartmentController {

	private DepartmentRepository repository;

	public DepartmentController(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("Department")
	public Iterable<Department> getDepartment(){
		return repository.findAll();
	}


//	@CrossOrigin(origins = "http://localhost:5173")
//	@GetMapping("api/departments/{department_name}")
//	public Iterable<Department> getProvi(@PathVariable String department_name){
//		System.out.println("department - department - department");
//		return repository.findByDepartmentName(department_name);
//	}

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("api/departments/a/{province_name}")
	public Iterable<Department> getAllDepartmentsOfAProvince(@PathVariable String province_name){
		return repository.findAllDepartmentsOfAProvince(province_name);
	}

}
