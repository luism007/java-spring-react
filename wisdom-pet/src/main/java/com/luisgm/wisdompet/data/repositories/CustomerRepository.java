package com.luisgm.wisdompet.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luisgm.wisdompet.data.entities.CustomerEntity;


public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{
    CustomerEntity findByEmail(String email);
}