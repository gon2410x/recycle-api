package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Department;
import com.juy.recycle_api.domain.Province;
import com.juy.recycle_api.domain.ProvinceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5174") // Permite peticiones desde localhost:3000
public class ProvinceController {

	private ProvinceRepository repository;

	public ProvinceController(ProvinceRepository repository) {
		super();
		this.repository = repository;
	}


	@CrossOrigin(origins = "http://localhost:5173") // Permite CORS solo para este método
	@GetMapping("/api/provinces")
	public Iterable<Province> getProvinces(){
		return repository.findAll();
	}


//	@CrossOrigin(origins = "http://localhost:5173") // Permite CORS solo para este método
//	@GetMapping("api/province/{province_name}")
//	public Iterable<Department> getProvi(@PathVariable String province_name){
//		System.out.println("department - department - department");
//		return repository.findByProvince(province_name);
//	}
}




