package com.berkaygulen.akbankbootcamphw2.service;

import com.berkaygulen.akbankbootcamphw2.dao.CommentRepository;
import com.berkaygulen.akbankbootcamphw2.entity.Comment;
import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import com.berkaygulen.akbankbootcamphw2.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Getter
@Setter
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {

    public CommentEntityService(CommentRepository repository) {
        super(repository);
    }

    public List<Comment> findCommentsByCustomerId(Long customerId){
        return getRepository().findCommentsByCustomerId(customerId);
    }
    public List<Comment> findCommentsByProductId(Long productId){
        return getRepository().findCommentsByProductId(productId);
    }


}
