package com.berkaygulen.akbankbootcamphw2.controller.contract.impl;

import com.berkaygulen.akbankbootcamphw2.controller.contract.ProductControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductUpdateRequestDTO;
import com.berkaygulen.akbankbootcamphw2.entity.Product;
import com.berkaygulen.akbankbootcamphw2.errorMessages.ProductErrorMessage;
import com.berkaygulen.akbankbootcamphw2.general.BusinessException;
import com.berkaygulen.akbankbootcamphw2.general.NotFoundException;
import com.berkaygulen.akbankbootcamphw2.mapper.ProductMapper;
import com.berkaygulen.akbankbootcamphw2.service.ProductEntityService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;

    @Override
    public ProductDTO save(ProductSaveRequestDTO request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);
        product = productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDTO(product);

    }

    @Override
    public List<ProductDTO> findAll() {

        List<Product> productList = productEntityService.findAll();
        if (productList.isEmpty()){
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }
        return ProductMapper.INSTANCE.convertToProductDTOList(productList);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = null;
        Optional<Product> optionalProduct = productEntityService.findById(id);
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }else {
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }

        return ProductMapper.INSTANCE.convertToProductDTO(product);

    }

    @Override
    public void delete(Long id) {
        if (productEntityService.isExist(id)){
            productEntityService.delete(id);
        }else {
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public ProductDTO updateProductPrize(Long id, ProductUpdateRequestDTO productUpdateRequestDTO) {
        Product product = null;
        Optional<Product> optionalProduct = productEntityService.findById(id);
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }else {
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }
        product = ProductMapper.INSTANCE.updateProduct(product,productUpdateRequestDTO);
        productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
}
