package com.berkaygulen.akbankbootcamphw2.controller;

import com.berkaygulen.akbankbootcamphw2.controller.contract.CustomerControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerDeleteRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.customerDTO.CustomerUpdateRequestDto;
import com.berkaygulen.akbankbootcamphw2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<RestResponse<CustomerDTO>> findByUserName(@PathVariable String userName){
        CustomerDTO customerDTO = customerControllerContract.findCustomerByUserName(userName);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequestDTO customerSaveRequest) {
        var customerDTO = customerControllerContract.save(customerSaveRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id, @RequestBody CustomerDeleteRequestDTO customerDeleteRequestDTO) {
        customerControllerContract.delete(id,customerDeleteRequestDTO);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> update(@PathVariable Long id, CustomerUpdateRequestDto customerUpdateRequestDto){
        CustomerDTO customerDTO = customerControllerContract.updateCustomer(id,customerUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }
}