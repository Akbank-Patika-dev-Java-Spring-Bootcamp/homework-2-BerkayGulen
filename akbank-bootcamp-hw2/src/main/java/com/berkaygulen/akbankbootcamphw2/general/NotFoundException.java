package com.berkaygulen.akbankbootcamphw2.general;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@Setter
public class NotFoundException extends BusinessException{
    public NotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
