package com.luisgm.wisdompet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.luisgm.wisdompet.data.entities.CustomerEntity;
import com.luisgm.wisdompet.data.repositories.CustomerRepository;
import com.luisgm.wisdompet.web.errors.NotFoundException;
import com.luisgm.wisdompet.web.models.Customer;


@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) { 
        this.customerRepository = customerRepository;
    }

    private CustomerEntity translateWebToDb(Customer customer) { 
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getCustomerId());
        entity.setAddress(customer.getAddress());
        entity.setEmail(customer.getEmailAddress());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setPhone(customer.getPhoneNumber());
        return entity;
    }

    private Customer translateDbToWeb(CustomerEntity entity) { 
        return new Customer(
            entity.getId(), 
            entity.getFirstName(), 
            entity.getLastName(), 
            entity.getEmail(), 
            entity.getAddress(), 
            entity.getPhone());
    }

    public List<Customer> getAllCustomers(String filterEmail)  { 
        List<Customer> customers = new ArrayList<>();
        if(StringUtils.hasLength(filterEmail)) { 
            CustomerEntity entity = this.customerRepository.findByEmail(filterEmail);
            customers.add(this.translateDbToWeb(entity));
        } else { 
            Iterable<CustomerEntity> entities = this.customerRepository.findAll();
            entities.forEach(entity -> {
                customers.add(this.translateDbToWeb(entity));
            });
        }
        return customers;
    }

    public Customer getCustomer(Long id)  {
        Optional<CustomerEntity> optional = this.customerRepository.findById(id);
        if(optional.isEmpty()) { 
            throw new NotFoundException("customer not found with id");
        }

        return this.translateDbToWeb(optional.get());
    }

    public Customer createOrUpdate(Customer customer) { 
        CustomerEntity entity = this.translateWebToDb(customer);
        entity = this.customerRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteCustomer (Long id) { 
        this.customerRepository.deleteById(id);
    }
}
