package com.juy.recycle_api.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DepartmentRepository extends CrudRepository<Department, Long>{

    List<Department> findByDepartmentName(@Param("department_name") String department_name);

//    @Query(value = "SELECT e.department_name FROM department e JOIN paises p ON e.pais_id = p.id WHERE p.pais_name = :paisName", nativeQuery = true)
    @Query(value = "SELECT * FROM department JOIN province ON province = id_province WHERE province_name = :provinceName", nativeQuery = true)
    List<Department> findAllDepartmentsOfAProvince(@Param("provinceName") String provinceName);

}
