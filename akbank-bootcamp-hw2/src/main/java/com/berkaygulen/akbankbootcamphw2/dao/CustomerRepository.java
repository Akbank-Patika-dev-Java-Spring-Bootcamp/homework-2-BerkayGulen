package com.berkaygulen.akbankbootcamphw2.dao;

import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);

    Customer findCustomerByUserName(String userName);

}
