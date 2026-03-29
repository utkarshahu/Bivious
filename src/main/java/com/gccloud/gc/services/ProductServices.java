package com.gccloud.gc.services;

import java.util.List;
import java.util.Optional;
import com.gccloud.gc.entities.Product;

public interface ProductServices {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);

    Optional<Product> updateProduct(Product product);

    void deleteProduct(Long id);
    
    void deleteAllProducts();

    boolean isProductExists(Long productId);


    List<Product> getAllProducts();

    boolean isProductExistsByCategory(String category);

}
