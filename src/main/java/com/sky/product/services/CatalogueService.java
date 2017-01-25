package com.sky.product.services;

import com.sky.product.Product;
import com.sky.product.dao.ProductDataProvider;
import com.sky.product.dao.ProductDataProviderStubImpl;

import java.util.ArrayList;

/**
 * Created by mac on 1/23/17.
 */
public class CatalogueService {
    private ProductDataProvider catalogueDataSource;

    public CatalogueService(ProductDataProvider catalogueDataSource) {
        this.catalogueDataSource = catalogueDataSource;
    }

    public ArrayList<ArrayList<Product>> fetchProductsByLocation(String locationID) {
        return this.catalogueDataSource.fetchProductsByLocation(locationID);
    }
}
