package com.sky.product.dao;

import com.sky.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.sky.product.ProductCategory.NEWS;
import static com.sky.product.ProductCategory.SPORTS;

public class ProductStub {
    private static Map<String, ArrayList<Product>> locationSpecificProducts;
    private static ArrayList<Product> basicProducts;
    private static final String LONDON = "LONDON";
    private static final String LIVERPOOL = "LIVERPOOL";

    public ProductStub() {
        locationSpecificProducts = new HashMap<String, ArrayList<Product>>();
        basicProducts = new ArrayList<>();

        createLondonProducts();
        createLiverpoolProducts();
        createBasicProducts();
    }

    public void createLondonProducts() {

        ArrayList<Product> londonProducts = new ArrayList<>();
        Product arsenalTV = new Product();
        arsenalTV.setName("Arsenal TV");
        arsenalTV.setLocationID(LONDON);
        arsenalTV.setCategory(SPORTS);
        londonProducts.add(arsenalTV);

        Product chelseaTV = new Product();
        chelseaTV.setName("Chelsea TV");
        chelseaTV.setLocationID(LONDON);
        chelseaTV.setCategory(SPORTS);
        londonProducts.add(chelseaTV);

        locationSpecificProducts.put(LONDON, londonProducts);
    }

    public void createLiverpoolProducts() {
        ArrayList<Product> liverpoolProducts = new ArrayList<>();
        Product arsenalTV = new Product();
        arsenalTV.setName("Liverpool TV");
        arsenalTV.setLocationID(LIVERPOOL);
        arsenalTV.setCategory(SPORTS);
        liverpoolProducts.add(arsenalTV);

        locationSpecificProducts.put(LIVERPOOL, liverpoolProducts);
    }

    public void createBasicProducts(){
        Product skyNews = new Product();
        skyNews.setName("Sky News");
        skyNews.setLocationID(null);
        skyNews.setCategory(NEWS);
        basicProducts.add(skyNews);

        Product skySportsNews = new Product();
        skySportsNews.setName("Sky Sports News");
        skySportsNews.setLocationID(null);
        skySportsNews.setCategory(NEWS);
        basicProducts.add(skySportsNews);

    }

    public static Map<String, ArrayList<Product>> fetchAllLocationSpecificProducts() {
        return locationSpecificProducts;
    }

    public static ArrayList<Product> fetchAllBasicProducts(){
        return basicProducts;
    }

}
