package com.example.ProductServicev1.Controller;

import Mapper.ProductMapper;
import com.example.ProductServicev1.Dtos.ProductRequestDto;
import com.example.ProductServicev1.Dtos.ProductResponseDto;
import com.example.ProductServicev1.Model.Product;
import com.example.ProductServicev1.Service.ProductService;
import com.example.ProductServicev1.Service.ProductServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        Product product = productMapper.toProduct(productRequestDto);
        Product savedProduct = productService.addProduct(product);
        ProductResponseDto prdto = productMapper.toDto(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(prdto);
    }
}
