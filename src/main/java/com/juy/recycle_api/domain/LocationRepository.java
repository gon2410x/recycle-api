package com.juy.recycle_api.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query(value = "SELECT * FROM location JOIN department ON department = id_department WHERE department_name = :departmentName", nativeQuery = true)
    List<Location> findAllLocationOfADepartment(@Param("departmentName") String departmentName);
}
