package com.sky.customer.services;


import com.sky.customer.dao.CustomerDataProvider;

public class CustomerLocationService {
    protected CustomerDataProvider customerDataProvider;

    public CustomerLocationService(CustomerDataProvider customerDataProvider) {
        this.customerDataProvider = customerDataProvider;
    }

    public String getCustomerLocationID(String customerId) {
        return customerDataProvider.fetchCustomer(customerId).getLocationID();
    }
}
