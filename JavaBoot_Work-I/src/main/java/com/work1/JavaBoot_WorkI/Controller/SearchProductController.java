package com.work1.JavaBoot_WorkI.Controller;

import com.work1.JavaBoot_WorkI.entity.Product;
import com.work1.JavaBoot_WorkI.response.ProductResponse;
import com.work1.JavaBoot_WorkI.response.ProductResponseList;
import com.work1.JavaBoot_WorkI.response.UserResposnse;
import com.work1.JavaBoot_WorkI.services.ProductService;
import com.work1.JavaBoot_WorkI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productbyname/{productName}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String productName){
        Optional<Product> result = productService.getProductByName(productName);
        ProductResponse product = new ProductResponse(result.orElseThrow());
        return ResponseEntity.ok(product);
    }

    @GetMapping("/productlikename/{productName}")
    public ResponseEntity<ProductResponseList> getProductLikeName(@PathVariable String productName){
        Optional<List<Product>> products = productService.getProductByLikeName(productName);
        ProductResponseList productList = new ProductResponseList(products.orElseThrow()) ;
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/productbypid/{productId}")
    public ResponseEntity<ProductResponse> getProductByProductId(@PathVariable int productId){
        System.out.println(productId);
        Optional<Product> result = productService.getProductByProductId(productId);
        ProductResponse product = new ProductResponse(result.orElseThrow());
        return ResponseEntity.ok(product);
    }

}
