package com.berkaygulen.akbankbootcamphw2.dto.commentDTO;

public record CommentDTO(

        Long id,
        Long customerId,
        Long productId,
        String comment

) {
}
