package com.berkaygulen.akbankbootcamphw2.controller.contract;

import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentDTO;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.entity.Comment;

import java.util.List;

public interface CommentControllerContract {

    List<CommentDTO> getCustomerComments(Long customerId);

    List<CommentDTO> getProductComments(Long productId);

    CommentDTO writeComment(CommentSaveRequestDTO commentSaveRequestDTO);

    void delete(Long commentId);
}
