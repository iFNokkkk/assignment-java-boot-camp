package com.work1.JavaBoot_WorkI.repository;

import com.work1.JavaBoot_WorkI.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByproductIdSuccess() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        productRepository.save(product);
        //Art
        Optional<Product> result = productRepository.findByproductId(12223);
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void findByproductIdFailed() {
        //Art
        Optional<Product> result = productRepository.findByproductId(12223);
        //Assert
        assertFalse(result.isPresent());
    }

    @Test
    void findByproductNameSuccess() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        productRepository.save(product);
        //Art
        Optional<Product> result = productRepository.findByproductName("ยาหม่อง");
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void findByproductNameFailed() {
        //Art
        Optional<Product> result = productRepository.findByproductName("ยาหม่อง");
        //Assert
        assertFalse(result.isPresent());
    }

    @Test
    void findByproductNameContainsSuccess() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        productRepository.save(product);
        //Art
        Optional<List<Product>> result = productRepository.findByproductNameContains("ยาหม่อง");
        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    void findByproductNameContainsFailed() {
        //Art
        Optional<List<Product>> result = productRepository.findByproductNameContains("ยาหม่อง");
        //Assert
        assertTrue(result.get().isEmpty());
    }
}