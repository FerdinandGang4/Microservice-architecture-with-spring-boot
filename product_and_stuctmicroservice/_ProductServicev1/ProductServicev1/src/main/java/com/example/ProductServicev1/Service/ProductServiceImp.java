package com.example.ProductServicev1.Service;

import com.example.ProductServicev1.Client.StockClient;
import com.example.ProductServicev1.Model.Product;
import com.example.ProductServicev1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    private final StockClient stockClient;

    public ProductServiceImp(ProductRepository productRepository, StockClient stockClient) {
        this.productRepository = productRepository;
        this.stockClient = stockClient;
    }

    @Override
    public Product addProduct(Product product) {
        // Call StockService before saving (example logic)
       var stock =  stockClient.getStock(product.getProductNumber());

        // Example: store stock returned from StockService
       product.setNumberOnStock(stock.getNumberOnStock());
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
