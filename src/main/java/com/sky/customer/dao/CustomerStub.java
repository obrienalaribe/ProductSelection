package com.sky.customer.dao;

import com.sky.customer.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 6/18/16.
 */
public final class CustomerStub {

    private static Map<String, Customer> customers;

    public CustomerStub() {
        customers = new HashMap<String, Customer>();
        customers.put("123", new Customer("LONDON"));
        customers.put("231", new Customer("LONDON"));
        customers.put("321", new Customer("LIVERPOOL"));
        customers.put("222", new Customer("LIVERPOOL"));
    }

    public static Map<String, Customer> fetchAllCustomers() {
        return customers;
    }
}
