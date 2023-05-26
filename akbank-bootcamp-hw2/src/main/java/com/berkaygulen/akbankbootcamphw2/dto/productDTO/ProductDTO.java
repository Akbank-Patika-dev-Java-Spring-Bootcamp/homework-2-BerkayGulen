package com.berkaygulen.akbankbootcamphw2.dto.productDTO;

public record ProductDTO(

        Long id,
        String name,
        String description,
        double price,
        int quantity
) {
}
