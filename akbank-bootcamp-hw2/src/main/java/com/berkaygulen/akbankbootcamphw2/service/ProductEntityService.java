package com.berkaygulen.akbankbootcamphw2.service;

import com.berkaygulen.akbankbootcamphw2.dao.ProductRepository;
import com.berkaygulen.akbankbootcamphw2.entity.Product;
import com.berkaygulen.akbankbootcamphw2.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    public ProductEntityService(ProductRepository repository) {
        super(repository);
    }



}
