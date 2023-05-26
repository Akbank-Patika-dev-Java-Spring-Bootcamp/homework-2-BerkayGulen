package com.berkaygulen.akbankbootcamphw2.dao;

import com.berkaygulen.akbankbootcamphw2.entity.Comment;
import com.berkaygulen.akbankbootcamphw2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByCustomerId(Long customerId);
    List<Comment> findCommentsByProductId(Long productId);


}
