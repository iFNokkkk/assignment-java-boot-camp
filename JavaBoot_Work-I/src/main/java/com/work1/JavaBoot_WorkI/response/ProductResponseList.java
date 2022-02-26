package com.work1.JavaBoot_WorkI.response;

import com.work1.JavaBoot_WorkI.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseList {
    private List<ProductResponse> productsResponse;

    public List<ProductResponse> getProductResponseList() {
        return productsResponse;
    }

    public void setProductResponseList(List<ProductResponse> productsResponse) {
        this.productsResponse = productsResponse;
    }

    public ProductResponseList() {
    }

    public ProductResponseList(List<Product> products) {
        productsResponse = new ArrayList<>();
        for (Product product: products) {
            if(product != null){
                ProductResponse productResponse = new ProductResponse(product);
                productsResponse.add(productResponse);
            }
        }
    }
}
