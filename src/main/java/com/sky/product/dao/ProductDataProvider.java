package com.sky.product.dao;

import com.sky.product.Product;

import java.util.ArrayList;

public interface ProductDataProvider {
    public ArrayList<ArrayList<Product>> fetchProductsByLocation(String locationID);

}
