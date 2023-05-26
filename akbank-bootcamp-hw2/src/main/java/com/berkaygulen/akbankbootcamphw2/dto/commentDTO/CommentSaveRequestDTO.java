package com.berkaygulen.akbankbootcamphw2.dto.commentDTO;

public record CommentSaveRequestDTO(

        Long customerId,
        Long productId,
        String comment

) {
}
