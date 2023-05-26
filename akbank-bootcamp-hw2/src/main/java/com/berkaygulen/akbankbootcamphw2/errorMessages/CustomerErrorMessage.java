package com.berkaygulen.akbankbootcamphw2.errorMessages;

import com.berkaygulen.akbankbootcamphw2.general.BaseErrorMessage;

public enum CustomerErrorMessage implements BaseErrorMessage {
    CUSTOMER_NOT_FOUND("Customer not found"),
    EMAIL_AND_USERNAME_IS_TAKEN("Email and User Name is taken!"),
    EMAIL_IS_TAKEN("Email is taken!!"),
    USERNAME_IS_TAKEN("User Name is taken!!"),
    USERNAME_AND_PHONE_NUMBER_DOES_NOT_MATCH("User Name and Phone number does not match!!!");

    private String message;

    CustomerErrorMessage(String message) {
        this.message = message;
    }

    CustomerErrorMessage() {

    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
