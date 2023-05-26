package com.berkaygulen.akbankbootcamphw2.errorMessages;

import com.berkaygulen.akbankbootcamphw2.general.BaseErrorMessage;

public enum ProductErrorMessage implements BaseErrorMessage {
    PRODUCT_NOT_FOUND("Product not Found!!!");

    private String message;
    ProductErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }



}
