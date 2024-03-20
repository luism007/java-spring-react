package com.luisgm.wisdompet.data.repositories;
import org.springframework.data.repository.CrudRepository;
import com.luisgm.wisdompet.data.entities.VendorEntity;

public interface VendorRepository extends CrudRepository<VendorEntity, Long> {
    VendorEntity findByEmail(String email);   
}
