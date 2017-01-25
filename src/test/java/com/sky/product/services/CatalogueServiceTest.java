package com.sky.product.services;

import com.sky.customer.exceptions.CustomerNotFoundException;
import com.sky.product.Product;
import com.sky.product.dao.ProductDataProviderStubImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

public class CatalogueServiceTest {

    private CatalogueService catalogueService;
    private static final String LONDON = "LONDON";
    private static final String LIVERPOOL = "LIVERPOOL";
    private static final String UNKNOWN = "UNKNOWN";

    @Before
    public void setup() {
        this.catalogueService = new CatalogueService(new ProductDataProviderStubImpl());
    }

    @Test
    public void fetchCatalogue_UsingUnknownLocation_ShouldReturnNull() {
        assertNull(this.catalogueService.fetchProductsByLocation(UNKNOWN));
    }

    @Test
    public void fetchCatalogue_UsingLocationID_ShouldReturnCatalogueByLocation() {
        ArrayList<ArrayList<Product>> catalogue = this.catalogueService.fetchProductsByLocation(LONDON);
        int basicProducts = catalogue.get(0).size();
        assertEquals(2, basicProducts);
        int locationSpecificProducts = catalogue.get(1).size();
        assertEquals(2, locationSpecificProducts);
        assertEquals(4, basicProducts + locationSpecificProducts);
    }
}
