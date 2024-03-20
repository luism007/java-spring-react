package com.luisgm.wisdompet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.luisgm.wisdompet.data.entities.VendorEntity;
import com.luisgm.wisdompet.data.repositories.VendorRepository;
import com.luisgm.wisdompet.web.errors.NotFoundException;
import com.luisgm.wisdompet.web.models.Vendor;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) { 
        this.vendorRepository = vendorRepository;
    }

    private VendorEntity translateWebToDb (Vendor vendor) { 
        VendorEntity entity = new VendorEntity();
        entity.setId(vendor.getVendorId());
        entity.setName(vendor.getName());
        entity.setAddress(vendor.getAddress());
        entity.setEmail(vendor.getEmail());
        entity.setPhone(vendor.getPhone());
        return entity;
    }

    private Vendor translateDbToWeb(VendorEntity entity) { 
        return new Vendor(
            entity.getId(),
            entity.getName(),
            entity.getAddress(),
            entity.getEmail(),
            entity.getPhone()
        );
    }

    public List<Vendor> getAllVendors(String filterEmail) { 
        List<Vendor> vendors = new ArrayList<>();
        if(StringUtils.hasLength(filterEmail)) { 
            VendorEntity entity = this.vendorRepository.findByEmail(filterEmail);
            vendors.add(this.translateDbToWeb(entity));
        } else  {
            Iterable<VendorEntity> entities = this.vendorRepository.findAll();
            entities.forEach(entity -> {
                vendors.add(this.translateDbToWeb(entity));
            });
        }
        return vendors;
    }

    public Vendor getVendor(Long id) {
        Optional<VendorEntity> optional = this.vendorRepository.findById(id);
        
        if(optional.isEmpty()) { 
            throw new NotFoundException("vendor not found with id");
        }

        return this.translateDbToWeb(optional.get());
    }
}
