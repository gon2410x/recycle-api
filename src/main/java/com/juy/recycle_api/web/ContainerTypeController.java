package com.juy.recycle_api.web;

import com.juy.recycle_api.domain.Container;
import com.juy.recycle_api.domain.ContainerRepository;
import com.juy.recycle_api.domain.ContainerTypeRepository;
import com.juy.recycle_api.domain.Container_type;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContainerTypeController {

    private final ContainerTypeRepository containerTypeRepository;

    public ContainerTypeController(ContainerTypeRepository containerTypeRepository) {
        this.containerTypeRepository = containerTypeRepository;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("api/container_types")
    public Iterable<Container_type> getContainers() {
        return containerTypeRepository.findAll();
    }
}

