package com.example.ProductServicev1.Service;

import com.example.ProductServicev1.Model.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(String id);
}
