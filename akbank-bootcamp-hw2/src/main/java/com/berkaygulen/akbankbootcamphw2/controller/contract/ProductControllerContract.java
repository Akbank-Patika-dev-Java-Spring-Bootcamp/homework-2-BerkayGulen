package com.berkaygulen.akbankbootcamphw2.controller.contract;

import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductUpdateRequestDTO;

import java.util.List;

public interface ProductControllerContract {

    ProductDTO save(ProductSaveRequestDTO request);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void delete(Long id);

    ProductDTO updateProductPrize(Long id, ProductUpdateRequestDTO productUpdateRequestDTO);

}
