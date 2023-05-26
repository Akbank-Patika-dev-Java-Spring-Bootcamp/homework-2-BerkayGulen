package com.berkaygulen.akbankbootcamphw2.controller;

import com.berkaygulen.akbankbootcamphw2.controller.contract.ProductControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductUpdateRequestDTO;
import com.berkaygulen.akbankbootcamphw2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductControllerContract productControllerContract;

    @GetMapping
    ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }
    @PostMapping
    ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequestDTO productSaveRequestDTO){
        var productDTO = productControllerContract.save(productSaveRequestDTO);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));

    }
    @DeleteMapping("/{id}")
    ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    ResponseEntity<RestResponse<ProductDTO>> updatePrice(@PathVariable Long id, @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO){
        ProductDTO productDTO = productControllerContract.updateProductPrize(id, productUpdateRequestDTO);
        return ResponseEntity.ok(RestResponse.of(productDTO));

    }

}
