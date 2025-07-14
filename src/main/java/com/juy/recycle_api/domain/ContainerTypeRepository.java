package com.juy.recycle_api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ContainerTypeRepository extends CrudRepository<Container_type, Long> {
//   List<Container_type> findAll();
}
