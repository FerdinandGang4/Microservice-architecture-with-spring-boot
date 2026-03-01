package com.example.ProductServicev1.Controller;

import com.example.ProductServicev1.Mapper.ProductMapper;
import com.example.ProductServicev1.Dtos.ProductRequestDto;
import com.example.ProductServicev1.Dtos.ProductResponseDto;
import com.example.ProductServicev1.Model.Product;
import com.example.ProductServicev1.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable String id)
    {
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toDto(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts()
    {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> dtos = new ArrayList<>();
        for(Product p : products)
        {
           var res =  productMapper.toDto(p);
            dtos.add(res);
        }
        return ResponseEntity.ok().body(dtos);
    }

}
