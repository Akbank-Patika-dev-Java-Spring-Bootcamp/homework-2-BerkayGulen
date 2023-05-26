package com.berkaygulen.akbankbootcamphw2.controller.contract.impl;

import com.berkaygulen.akbankbootcamphw2.controller.contract.CustomerControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDeleteRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerUpdateRequestDto;
import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import com.berkaygulen.akbankbootcamphw2.errorMessages.CustomerErrorMessage;
import com.berkaygulen.akbankbootcamphw2.general.BusinessException;
import com.berkaygulen.akbankbootcamphw2.general.NotFoundException;
import com.berkaygulen.akbankbootcamphw2.mapper.CustomerMapper;
import com.berkaygulen.akbankbootcamphw2.service.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerEntityService customerEntityService;

    @Override
    public CustomerDTO save(CustomerSaveRequestDTO request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        boolean isEmailAndUserNameTaken = customerEntityService.existByUserName(customer.getUserName()) && customerEntityService.existByEmail(customer.getEmail());
        boolean isEmailTaken = customerEntityService.existByEmail(customer.getEmail());
        boolean isUserNameTaken = customerEntityService.existByUserName(customer.getUserName());
        if (isEmailAndUserNameTaken) {
            throw new BusinessException(CustomerErrorMessage.EMAIL_AND_USERNAME_IS_TAKEN);
//            System.out.println("Email and username is taken");
        } else if (isUserNameTaken) {
//            System.out.println("UserName is taken");
            throw new BusinessException(CustomerErrorMessage.USERNAME_IS_TAKEN);
        } else if (isEmailTaken) {
            throw new BusinessException(CustomerErrorMessage.EMAIL_IS_TAKEN);
//            System.out.println("Email is taken");
        } else {
            customer = customerEntityService.save(customer);
            return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
        }
//        customer = customerEntityService.save(customer);

//        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = customerEntityService.findAll();
        if (customerList.isEmpty()) {

            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        }
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }

    @Override
    public void delete(Long id, CustomerDeleteRequestDTO customerDeleteRequestDTO) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerEntityService.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        }
        if (!customer.getUserName().equals(customerDeleteRequestDTO.userName())
                && !customer.getPhone().equals(customerDeleteRequestDTO.phone())){
            throw new BusinessException(CustomerErrorMessage.USERNAME_AND_PHONE_NUMBER_DOES_NOT_MATCH);
        }

        customerEntityService.delete(id);

    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerEntityService.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        }
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);

    }

    @Override
    public CustomerDTO findCustomerByUserName(String userName) {
        Customer customer = customerEntityService.findCustomerByUserName(userName);
        if (customer == null) {
            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        }
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerEntityService.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        }

        customer = CustomerMapper.INSTANCE.updateCustomer(customer,customerUpdateRequestDto);
        customerEntityService.save(customer);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);

    }


}
