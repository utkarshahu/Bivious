package com.gccloud.gc.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gccloud.gc.entities.Product;
import com.gccloud.gc.helper.ResourceNotFoundException;
import com.gccloud.gc.repositories.ProductRepo;
import com.gccloud.gc.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        Product product2 = productRepo.findById(product.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setModel(product.getModel());
        product2.setPicture(product.getPicture());
        product2.setCategory(product.getCategory());
        product2.setCategoryTags(product.getCategoryTags());

        return Optional.of(productRepo.save(product2));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepo.delete(product);
    }

    @Override
    public void deleteAllProducts() {
        productRepo.deleteAll();
    }

    @Override
    public boolean isProductExists(Long productId) {
        return productRepo.existsById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public boolean isProductExistsByCategory(String category) {
        return productRepo.findByCategory(category) != null;
    }
}
