package com.berkaygulen.akbankbootcamphw2.mapper;

import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.dto.productDTO.ProductUpdateRequestDTO;
import com.berkaygulen.akbankbootcamphw2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequestDTO productSaveRequestDTO);

    ProductDTO convertToProductDTO(Product product);

    Product updateProduct(@MappingTarget Product product, ProductUpdateRequestDTO productUpdateRequestDTO);

    List<ProductDTO> convertToProductDTOList(List<Product> productList);


}
