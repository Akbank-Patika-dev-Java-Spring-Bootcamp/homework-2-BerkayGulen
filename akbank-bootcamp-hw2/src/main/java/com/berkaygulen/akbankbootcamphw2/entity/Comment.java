package com.berkaygulen.akbankbootcamphw2.entity;

import com.berkaygulen.akbankbootcamphw2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment",sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "COMMENT", length = 500)
    private String comment;

}
