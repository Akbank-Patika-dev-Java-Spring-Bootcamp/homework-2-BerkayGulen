package com.berkaygulen.akbankbootcamphw2.service;

import com.berkaygulen.akbankbootcamphw2.dao.CustomerRepository;
import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import com.berkaygulen.akbankbootcamphw2.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {
    public CustomerEntityService(CustomerRepository repository) {
        super(repository);
    }

    public boolean existByUserName(String userName){
        return getRepository().existsByUserName(userName);
    }

    public boolean existByEmail(String email){
        return getRepository().existsByEmail(email);
    }

    public Customer findCustomerByUserName(String userName){
        return getRepository().findCustomerByUserName(userName);
    }

}
