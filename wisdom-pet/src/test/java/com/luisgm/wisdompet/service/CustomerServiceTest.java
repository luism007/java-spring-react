package com.luisgm.wisdompet.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.luisgm.wisdompet.data.entities.CustomerEntity;
import com.luisgm.wisdompet.data.repositories.CustomerRepository;
import com.luisgm.wisdompet.services.CustomerService;
import com.luisgm.wisdompet.web.errors.NotFoundException;
import com.luisgm.wisdompet.web.models.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void getAllCustomersTest() { 
        Mockito.doReturn(getMockCustomers(2)).when(customerRepository).findAll();
        List<Customer> customers = this.customerService.getAllCustomers(null);

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomerTest() { 
        CustomerEntity entity = getMockCustomerEntity();
        Optional<CustomerEntity> optional = Optional.of(entity);
        Mockito.doReturn(optional).when(customerRepository).findById(entity.getId());

        Customer customer = customerService.getCustomer(entity.getId());
        assertNotNull(customer);
        assertEquals("firstName", customer.getFirstName());

    }

    @Test
    void getCustomerNotExistsTest() { 
        CustomerEntity entity = getMockCustomerEntity();
        Optional<CustomerEntity> optional = Optional.empty();

        Mockito.doReturn(optional).when(customerRepository).findById(entity.getId());
        assertThrows(NotFoundException.class, ()-> customerService.getCustomer(entity.getId()));
    }

    @Test
    void findCustomerByEmail() { 
        CustomerEntity entity = getMockCustomerEntity();

        Mockito.doReturn(entity).when(customerRepository).findByEmail(entity.getEmail());
       List<Customer> customers = customerService.getAllCustomers(entity.getEmail());

        assertNotNull(entity);
        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals("email@test.com", customers.getFirst().getEmailAddress());
    }

    // @Test
    // void addCustomer() { 
    //     CustomerEntity entity = getMockCustomerEntity();

    //     when(customerRepository.findByEmail(entity.getEmail())).thenReturn(null);
    //     when(customerRepository.save(any(CustomerEntity.class))).thenReturn(entity);

    //     Customer customer = getMockCustomer();

    //     customer = customerService.createOrUpdate(customer);

    //     assertNotNull(customer);
    //     assertEquals("lastName", customer.getLastName());

    // }
    private Iterable<CustomerEntity> getMockCustomers (int size) { 
        List<CustomerEntity> customers = new ArrayList<>(2);

        for(int i = 0; i < size; i++) {
            Random rd = new Random();
            customers.add(new CustomerEntity(rd.nextLong(), "firstName" + i, "lastName" + i, "email" + i + "@test.com", "555-515-1234", "1234 Main Street"));
        }

        return customers;
    }

    private CustomerEntity getMockCustomerEntity(){
        CustomerEntity customer = new CustomerEntity((long) 0, 
                                        "firstName",
                                        "lastName",
                                        "email@test.com",
                                        "555-155-1234",
                                        "1234 Main Street");
        return customer;
    }

    private Customer getMockCustomer() {
        return new Customer((long) 0, "firstName", "lastName", "emailAddress", "phoneNumber", "1234 Main Street");
    }
}