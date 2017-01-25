package com.sky.customer.services;

import com.sky.customer.dao.CustomerDataProviderStubImpl;
import com.sky.customer.exceptions.CustomerNotFoundException;
import com.sky.customer.services.CustomerLocationService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerLocationServiceTest {

    public static final String CUSTOMER_ID = "123";
    public static final String INVALID_CUSTOMER_ID = "555";
    public static final String LONDON = "LONDON";
    private CustomerLocationService customerLocationService;

    @Before
    public void setUp() {
        customerLocationService = new CustomerLocationService(new CustomerDataProviderStubImpl());
    }

    @Test
    public void fetchLocationID_ByCustomerID() {
        String customerLocation = customerLocationService.getCustomerLocationID(CUSTOMER_ID);
        assertEquals(LONDON, customerLocation);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void fetchLocationID_UsingInvalidCustomerID() {
       customerLocationService.getCustomerLocationID(INVALID_CUSTOMER_ID);
    }
}
