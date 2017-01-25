package com.sky.product.dao;

import com.sky.product.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mac on 1/22/17.
 */
public class ProductDataProviderStubImpl implements ProductDataProvider {
    private ProductStub productDataSource;

    public ProductDataProviderStubImpl() {
        this.productDataSource = new ProductStub();
    }

    @Override
    public ArrayList<ArrayList<Product>> fetchProductsByLocation(String locationID) {
        ArrayList<ArrayList<Product>> productCatalogue = new ArrayList<ArrayList<Product>>();
        productCatalogue.add(this.productDataSource.fetchAllBasicProducts());

        Map<String, ArrayList<Product>> locationSpecificProducts = this.productDataSource.fetchAllLocationSpecificProducts();

        if (locationSpecificProducts.containsKey(locationID)) {
            productCatalogue.add(locationSpecificProducts.get(locationID));
            return productCatalogue;
        }
        return null;
    }
}
