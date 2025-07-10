package com.juy.recycle_api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProvinceRepository extends CrudRepository<Province, Long> {

//    List<Department> findByProvince(String provinceName);
}
