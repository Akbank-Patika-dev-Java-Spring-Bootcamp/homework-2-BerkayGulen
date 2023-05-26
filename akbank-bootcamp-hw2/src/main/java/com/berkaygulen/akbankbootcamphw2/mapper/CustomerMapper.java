package com.berkaygulen.akbankbootcamphw2.mapper;

import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerUpdateRequestDto;
import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOList(List<Customer> customerList);

    Customer updateCustomer(@MappingTarget Customer customer, CustomerUpdateRequestDto customerUpdateRequestDto);
}
