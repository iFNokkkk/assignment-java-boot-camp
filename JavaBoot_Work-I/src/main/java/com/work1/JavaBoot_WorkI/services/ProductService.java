package com.work1.JavaBoot_WorkI.services;

import com.work1.JavaBoot_WorkI.entity.Product;
import com.work1.JavaBoot_WorkI.exception.ProductNotFoundException;
import com.work1.JavaBoot_WorkI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductByName(String productName) {
        Optional<Product> result = productRepository.findByproductName(productName);
        if (result.isEmpty()) {
            throw new ProductNotFoundException(productName);
        }
        return result;
    }

    public Optional<List<Product>> getProductByLikeName(String productName) {
        Optional<List<Product>> result = productRepository.findByproductNameContains(productName);
        if (result.isEmpty() || result.get().isEmpty()) {
            throw new ProductNotFoundException(productName);
        }
        return result;
    }

    public Optional<Product> getProductByProductId(int productId){
        Optional<Product> result = productRepository.findByproductId(productId);
        if (result.isEmpty()) {
            throw new ProductNotFoundException(String.valueOf(productId));
        }
        return result;
    }
}
