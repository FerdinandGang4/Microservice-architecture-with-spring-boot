package com.example.StockServicev1.Dto;


public class StockResponseDto {
    private final String productNumber;
    private final int numberOnStock;

    public StockResponseDto(String productNumber, int numberOnStock) {
        this.productNumber = productNumber;
        this.numberOnStock = numberOnStock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public int getNumberOnStock() {
        return numberOnStock;
    }
}
