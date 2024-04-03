package com.luisgm.wisdompet.services;

import java.util.ArrayList;
import java.util.List;

import com.luisgm.wisdompet.data.entities.ServiceEntity;
import com.luisgm.wisdompet.data.repositories.ServiceRepository;
import com.luisgm.wisdompet.web.models.Service;

@org.springframework.stereotype.Service
public class ServiceService {
    
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    private ServiceEntity translateWebToDb (Service service) {
        ServiceEntity entity = new ServiceEntity();

        entity.setId(service.getServiceId());
        entity.setName(service.getName());
        entity.setPrice(service.getPrice());

        return entity;
    }

    private Service translateDbToWeb (ServiceEntity entity) {
        return new Service(
            entity.getId(),
            entity.getName(),
            entity.getPrice()
        );
    } 


    public List<Service> getAllServices() {
        Iterable<ServiceEntity> serviceEntities = this.serviceRepository.findAll();
        List<Service> services = new ArrayList<>();

        serviceEntities.forEach(entity -> {
            services.add(this.translateDbToWeb(entity));
        });

        return services;
    } 

    public Service createOrUpdate(Service service) {
        ServiceEntity entity = this.translateWebToDb(service);
        entity = this.serviceRepository.save(entity);
        return this.translateDbToWeb(entity);
    } 

    public void deleteService(long id) {
        this.serviceRepository.deleteById(id);
    }

}
