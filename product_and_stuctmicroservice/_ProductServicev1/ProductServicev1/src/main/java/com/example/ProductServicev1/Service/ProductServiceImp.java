package com.example.ProductServicev1.Service;

import com.example.ProductServicev1.Model.Product;
import com.example.ProductServicev1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
      return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
         return productRepository.findById(id).orElseThrow(
                 ()-> new RuntimeException("no such product with id "+ id)
         );
       }
}
