package com.example.ProductServicev1.Dtos;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String productNumber;
    private String productName;
    private int numberOnStock;
}
