package com.sky.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Failure Exception: There was a problem retrieving the customer information");
    }
}
