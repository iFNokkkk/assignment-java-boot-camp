package com.work1.JavaBoot_WorkI.services;

import com.work1.JavaBoot_WorkI.entity.Product;
import com.work1.JavaBoot_WorkI.repository.ProductRepository;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    void successGetProductByName() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        when(productRepository.findByproductName("ยาหม่อง")).thenReturn(Optional.of(product));
        //Art
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<Product> result = productService.getProductByName("ยาหม่อง");
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void successGetProductByLikeName() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        when(productRepository.findByproductNameContains("ยาหม่อง")).thenReturn(Optional.of(productList));
        //Art
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<List<Product>> result = productService.getProductByLikeName("ยาหม่อง");
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void successGetProductByProductId() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        when(productRepository.findByproductId(12223)).thenReturn(Optional.of(product));
        //Art
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<Product> result = productService.getProductByProductId(12223);
        //Assert
        assertTrue(result.isPresent());
    }
}