package com.gccloud.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gccloud.gc.entities.Product;
import com.gccloud.gc.services.ProductServices;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
// Handles product API requests from frontend (React)
public class ProductAPIController {

    @Autowired
    private ProductServices productServices; // service layer call

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // create new product
        return productServices.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        // fetch all products
        return productServices.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // fetch single product
        return productServices.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // update product
        product.setProductId(id);
        return productServices.updateProduct(product)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        // delete product
        productServices.deleteProduct(id);
        return "Product deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllProducts() {
        // delete all products
        productServices.deleteAllProducts();
        return "All products deleted successfully";
    }
}
