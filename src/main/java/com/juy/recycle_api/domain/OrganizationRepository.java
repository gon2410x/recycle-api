package com.juy.recycle_api.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {
//    Long findLocationByProvinceByDepartmentByLocation(String province, String department, String location);

    final String queryLocation =
            "SELECT id_location FROM location " +
                    "JOIN department ON department = id_department " +
                    "JOIN province ON province = id_province " +
                    "WHERE province_name = :provinceName AND department_name = :departmentName AND location_name = :locationName";
    @Query(value = queryLocation, nativeQuery = true)
    Long findLocationByProvinceByDepartmentByLocation
            (@Param("provinceName") String provinceName,
             @Param("departmentName") String departmentName,
             @Param("locationName") String locationName);
}

