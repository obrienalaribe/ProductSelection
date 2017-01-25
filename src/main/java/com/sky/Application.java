package com.sky;

import com.sky.customer.dao.CustomerDataProviderStubImpl;
import com.sky.customer.services.CustomerLocationService;
import com.sky.product.Product;
import com.sky.product.dao.ProductDataProviderStubImpl;
import com.sky.product.services.CatalogueService;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {


    public static void main(String[] args) {

        get("/products", (request, response) -> {

            String customerID = "123";

            if (request.cookie("customerID") != null){
                customerID = request.cookie("customerID");
            }
            CustomerLocationService customerLocationService = new CustomerLocationService(new CustomerDataProviderStubImpl());
            String customerLocation = customerLocationService.getCustomerLocationID(customerID);

            CatalogueService catalogueService = new CatalogueService(new ProductDataProviderStubImpl());
            ArrayList<ArrayList<Product>> catalogue = catalogueService.fetchProductsByLocation(customerLocation);

            Map<String, Object> model = new HashMap<>();
            model.put("basicProducts", catalogue.get(0));
            model.put("locationProducts", catalogue.get(1));
            model.put("customerID", customerID);

            return new ModelAndView(model, "products.vm");
        }, new VelocityTemplateEngine());

        post("/products", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            try {
                String[] selectedProducts = request.queryParamsValues("products[]");
                String customerID = request.queryParams("customerID");

                model.put("selectedProducts", selectedProducts);
                model.put("customerID", customerID);

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

            return new ModelAndView(model, "confirmation.vm");
        }, new VelocityTemplateEngine());

    }




}