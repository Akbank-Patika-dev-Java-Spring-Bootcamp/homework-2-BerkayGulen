package com.berkaygulen.akbankbootcamphw2.entity;

import com.berkaygulen.akbankbootcamphw2.enums.EnumStatus;
import com.berkaygulen.akbankbootcamphw2.enums.EnumUserType;
import com.berkaygulen.akbankbootcamphw2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer",sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USERNAME", length = 50, nullable = false,unique = true)
    @NotBlank
    private String userName;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    @NotBlank
    private String password;

    @Column(name = "EMAIL", length = 50,nullable = false,unique = true)
    @Email
    private String email;

    @Column(name = "PHONE_NUMBER", length = 50,nullable = false,unique = true)
    private String phone;


    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private EnumUserType userType;

}
