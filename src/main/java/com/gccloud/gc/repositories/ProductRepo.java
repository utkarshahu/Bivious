package com.gccloud.gc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gccloud.gc.entities.Product;

@Repository
// Handles DB operations for Product
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);
    // fetch all products of a category
}
