package com.example.ProductServicev1.Dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductRequestDto {
    private String productName;
    private int numberOnStock;
}
