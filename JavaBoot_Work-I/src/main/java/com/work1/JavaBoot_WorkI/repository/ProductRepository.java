package com.work1.JavaBoot_WorkI.repository;

import com.work1.JavaBoot_WorkI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(String id);

    Optional<Product> findByproductId(int productId);

    Optional<Product> findByproductName(String productName);

    Optional<List<Product>> findByproductNameContains(String productName);
}
