package com.berkaygulen.akbankbootcamphw2.controller.contract.impl;

import com.berkaygulen.akbankbootcamphw2.controller.contract.CommentControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentDTO;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.entity.Comment;
import com.berkaygulen.akbankbootcamphw2.errorMessages.CommentErrorMessage;
import com.berkaygulen.akbankbootcamphw2.errorMessages.CustomerErrorMessage;
import com.berkaygulen.akbankbootcamphw2.errorMessages.ProductErrorMessage;
import com.berkaygulen.akbankbootcamphw2.general.NotFoundException;
import com.berkaygulen.akbankbootcamphw2.mapper.CommentMapper;
import com.berkaygulen.akbankbootcamphw2.service.CommentEntityService;
import com.berkaygulen.akbankbootcamphw2.service.CustomerEntityService;
import com.berkaygulen.akbankbootcamphw2.service.ProductEntityService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService commentEntityService;
    private final CustomerEntityService customerEntityService;
    private final ProductEntityService productEntityService;
    @Override
    public List<CommentDTO> getCustomerComments(Long customerId) {
       if (!customerEntityService.isExist(customerId)){
           throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
       }
       List<Comment> commentList = commentEntityService.findCommentsByCustomerId(customerId);
       if (commentList.isEmpty()){
           throw new NotFoundException(CommentErrorMessage.COMMENT_DOES_NOT_EXISTS_CUSTOMER);
       }
       return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

    @Override
    public List<CommentDTO> getProductComments(Long productId) {
        if (!productEntityService.isExist(productId)){
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }
        List<Comment> commentList = commentEntityService.findCommentsByProductId(productId);
        if (commentList.isEmpty()){
            throw new NotFoundException(CommentErrorMessage.COMMENT_DOES_NOT_EXISTS_PRODUCT);
        }
        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

    @Override
    public CommentDTO writeComment(CommentSaveRequestDTO commentSaveRequestDTO) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequestDTO);

        if (!customerEntityService.isExist(comment.getCustomerId())){
            throw new NotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND);
        } else if (!productEntityService.isExist(comment.getProductId())) {
            throw new NotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }else {
            comment = commentEntityService.save(comment);
        }

        return CommentMapper.INSTANCE.convertToCommentDTO(comment);

    }

    @Override
    public void delete(Long commentId) {
        if (commentEntityService.isExist(commentId)){
            commentEntityService.delete(commentId);
        }else {
            throw new NotFoundException(CommentErrorMessage.COMMENT_NOT_FOUND_EXCEPTION);
        }
    }
}
