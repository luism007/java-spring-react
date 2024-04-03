package com.luisgm.wisdompet.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luisgm.wisdompet.data.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>{
    ProductEntity findByName(String name);
}
