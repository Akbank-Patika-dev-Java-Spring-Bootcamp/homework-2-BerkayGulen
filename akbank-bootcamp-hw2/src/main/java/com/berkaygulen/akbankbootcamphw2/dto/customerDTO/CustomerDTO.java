package com.berkaygulen.akbankbootcamphw2.dto.customerDTO;

import com.berkaygulen.akbankbootcamphw2.enums.EnumStatus;
import com.berkaygulen.akbankbootcamphw2.enums.EnumUserType;

public record CustomerDTO(

        Long id,
        String name,
        String surname,
        String userName,
        String email,
        String phone,
        EnumStatus status,
        EnumUserType userType

) {
}
