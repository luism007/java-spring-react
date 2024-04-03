package com.luisgm.wisdompet.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luisgm.wisdompet.data.entities.ServiceEntity;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
    ServiceEntity findByName(String name);
}
