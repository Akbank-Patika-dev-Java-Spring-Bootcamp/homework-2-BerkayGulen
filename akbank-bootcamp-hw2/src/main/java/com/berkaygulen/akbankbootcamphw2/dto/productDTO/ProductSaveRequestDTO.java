package com.berkaygulen.akbankbootcamphw2.dto.productDTO;

public record ProductSaveRequestDTO(

        String name,
        String description,
        double price,
        int quantity

) {
}
