package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Container;
import com.juy.recycle_api.domain.ContainerRepository;

import org.springframework.web.bind.annotation.*;


@RestController
public class ContainerController {

	private final ContainerRepository containerRepository;

	public ContainerController(ContainerRepository container) {
		this.containerRepository = container;
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("api/containers-all")
	public Iterable<Container> getContainers() {
		return containerRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("api/containers/search")
	public Iterable<Container> getContainers2(
			@RequestParam String province,
			@RequestParam String department,
			@RequestParam String location,
			@RequestParam String residuo) {
		return containerRepository.findAllContainerByProvinceByDepartmentByLocationByResiduo(province,department,location,residuo);
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("api/containers/register")
	public Container createContainer(@RequestBody Container container) {

		final String residue = container.getContainer_type().getResiduo();
		final String location = container.getLocation().getLocation_name();
		final String department = container.getLocation().getDepartment().getDepartment_name();
		final String province = container.getLocation().getDepartment().getProvince().getProvince_name();
		final String organizationName = container.getOrganization().getOrganization_name();


		Long id_container_type = containerRepository.findContainerByResidue(residue);
		container.getContainer_type().setResiduo(null);
		container.getContainer_type().setId_container_type(id_container_type);

		Long id_organization = containerRepository.findOrganizationByOrganizationName(organizationName);
		container.getOrganization().setOrganization_name(null);
		container.getOrganization().setId_organization(id_organization);

		Long id_location = containerRepository.findLocationByProvinceByDepartmentByLocation(province,department,location);
		container.getLocation().getDepartment().getProvince().setProvince_name(null);
		container.getLocation().getDepartment().setDepartment_name(null);
		container.getLocation().setLocation_name(null);
		container.getLocation().setId_location(id_location);

//		container.getContainer_type().setResiduo("naddaaaa!");
		return containerRepository.save(container);

//		return container;
	}
}
