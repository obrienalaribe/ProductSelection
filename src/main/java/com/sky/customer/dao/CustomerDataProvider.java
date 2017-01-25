package com.sky.customer.dao;

import com.sky.customer.Customer;

public interface CustomerDataProvider {
    public Customer fetchCustomer(String customerId);
}
