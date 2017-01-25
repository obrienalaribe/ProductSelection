package com.sky.customer.dao;

import com.sky.customer.Customer;
import com.sky.customer.exceptions.CustomerNotFoundException;

import java.util.Map;

public class CustomerDataProviderStubImpl implements CustomerDataProvider {

    private CustomerStub customerDatasource;

    public CustomerDataProviderStubImpl() {
        this.customerDatasource =  new CustomerStub();
    }

    @Override
    public Customer fetchCustomer(String customerId) {
        Map<String, Customer> returnedCustomers = customerDatasource.fetchAllCustomers();
        if (returnedCustomers != null && returnedCustomers.containsKey(customerId)) {
            return returnedCustomers.get(customerId);
        }
        throw new CustomerNotFoundException();
    }
}
