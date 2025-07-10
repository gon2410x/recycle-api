package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Department;
import com.juy.recycle_api.domain.Location;
import com.juy.recycle_api.domain.LocationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LocationController {

	private LocationRepository repository;

	public LocationController(LocationRepository repository) {
		super();
		this.repository = repository;
	}

//	@GetMapping("/location")
//	public Iterable<Location> getLocations(){
//		return repository.findAll();
//	}


	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("api/locations/a/{department_name}")
	public Iterable<Location> getAllLocationOfADepartment(@PathVariable String department_name){
		return repository.findAllLocationOfADepartment(department_name);
	}
}
