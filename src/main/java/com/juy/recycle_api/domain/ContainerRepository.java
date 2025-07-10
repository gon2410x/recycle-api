package com.juy.recycle_api.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContainerRepository extends CrudRepository<Container, Long> {

    final String query = "SELECT * FROM container " +
                         "JOIN location ON location = id_location "+
                         "JOIN department ON department = id_department " +
                         "JOIN province ON province = id_province " +
                         "JOIN container_type ON container_type = id_container_type " +
                         "WHERE location_name = :locationName AND " +
                                "department_name = :departmentName AND " +
                                "province_name = :provinceName AND " +
                                "residuo = :residuo";
    @Query(value = query, nativeQuery = true)
    List<Container> findAllContainerByProvinceByDepartmentByLocationByResiduo
            (@Param("provinceName") String provinceName,
             @Param("departmentName") String departmentName,
             @Param("locationName") String locationName,
             @Param("residuo") String residuo);


    final String queryResidue = "SELECT id_container_type FROM container_type " +
                                "WHERE residuo =:residue";
    @Query(value = queryResidue, nativeQuery = true)
    Long findContainerByResidue(@Param("residue") String residue);

    final String queryOrganizationName =
            "SELECT id_organization FROM organization " +
            "WHERE organization_name =:organizationName";
    @Query(value = queryOrganizationName, nativeQuery = true)
    Long findOrganizationByOrganizationName(String organizationName);

    final String queryLocation =
            "SELECT id_location FROM location " +
            "JOIN department ON department = id_department " +
            "JOIN province ON province = id_province " +
            "WHERE province_name = :provinceName AND department_name = :departmentName AND location_name = :locationName";
    @Query(value = queryLocation, nativeQuery = true)
    Long findLocationByProvinceByDepartmentByLocation(String provinceName, String departmentName, String locationName);
}
