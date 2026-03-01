package com.example.ProductServicev1.Repository;

import com.example.ProductServicev1.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product , String> {
}
