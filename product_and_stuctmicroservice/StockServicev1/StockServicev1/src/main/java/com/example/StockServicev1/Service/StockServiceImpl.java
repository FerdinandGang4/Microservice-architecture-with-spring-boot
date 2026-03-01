package com.example.StockServicev1.Service;

import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
    @Override
    public int getStockByProductNumber(String productNumber) {
        return switch (productNumber) {
            case "P1001" -> 10;
            case "P1002" -> 25;
            case "P1003" -> 0;
            default -> 0;
        };
    }
}
