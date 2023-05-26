package com.berkaygulen.akbankbootcamphw2.controller.contract;

import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDeleteRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerUpdateRequestDto;

import java.util.List;

public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequestDTO request);
    List<CustomerDTO> findAll();
    void delete(Long id, CustomerDeleteRequestDTO customerDeleteRequestDTO);
    CustomerDTO findById(Long id);

    CustomerDTO findCustomerByUserName(String userName);

    CustomerDTO updateCustomer(Long id, CustomerUpdateRequestDto customerUpdateRequestDto);



}
