package com.luisgm.wisdompet.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="CUSTOMERS")
@Data
@ToString
public class CustomerEntity {

        public CustomerEntity(long randomUUID, String firstName, String lastName, String email, String phoneNumber,
                        String address) {
                this.setId(randomUUID);
                this.setFirstName(firstName);
                this.setLastName(lastName);
                this.setEmail(email);
                this.setPhone(phoneNumber);
                this.setAddress(address);
        }

        public CustomerEntity() { 
                
        }

        @Id
        @Column(name = "CUSTOMER_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "FIRST_NAME")
        private String firstName;
        @Column(name = "LAST_NAME")
        private String lastName;
        @Column(name = "EMAIL")
        private String email;
        @Column(name = "PHONE")
        private String phone;
        @Column(name = "ADDRESS")
        private String address;


}