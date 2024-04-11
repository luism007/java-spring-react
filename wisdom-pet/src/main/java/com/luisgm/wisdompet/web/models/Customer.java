package com.luisgm.wisdompet.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    public Customer(
            Long id,
            String firstName,
            String lastName,
            String emailAddress,
            String phoneNumber,
            String address) {
        //TODO Auto-generated constructor stub
        this.customerId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public Long customerId; 
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public String address;
}
