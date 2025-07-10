package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Container;
import com.juy.recycle_api.domain.Organization;
import com.juy.recycle_api.domain.OrganizationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {
    private OrganizationRepository organizationRepositor;


    public OrganizationController(OrganizationRepository organizationRepositor) {
        this.organizationRepositor = organizationRepositor;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("api/organizations-all")
    public Iterable<Organization> getOrganization() {
        return organizationRepositor.findAll();
    }

    @CrossOrigin(origins =  "http://localhost:5173")
    @PostMapping("api/organizations/register")
    public Organization createOrganization(@RequestBody Organization organization){

        final String organizationName = organization.getOrganization_name();
        final String organizationType = organization.getOrganization_type();
        final String email = organization.getEmail();
        final String phone = organization.getPhone();
        final String location = organization.getLocation().getLocation_name();
        final String department = organization.getLocation().getDepartment().getDepartment_name();
        final String province = organization.getLocation().getDepartment().getProvince().getProvince_name();

        Long id_location = organizationRepositor.findLocationByProvinceByDepartmentByLocation(province, department, location);
        organization.getLocation().getDepartment().getProvince().setProvince_name(null);
        organization.getLocation().getDepartment().setDepartment_name(null);
        organization.getLocation().setLocation_name(null);
        organization.getLocation().setId_location(id_location);

        return organizationRepositor.save(organization);

//        System.out.println(organizationName+organizationType+email+phone+location+department+province+":"+id_location);
//        return organization;
    }
}
