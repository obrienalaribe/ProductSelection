package com.sky.customer;

public class Customer {
    private final String locationID;

    public Customer(String location) {
        this.locationID = location;
    }

    public String getLocationID() {
        return locationID;
    }
}
