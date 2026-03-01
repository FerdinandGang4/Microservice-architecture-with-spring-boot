package com.example.StockServicev1.Controller;

import com.example.StockServicev1.Dto.StockResponseDto;
import com.example.StockServicev1.Service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<StockResponseDto> getStock(
            @PathVariable String productNumber) {

        int stock = stockService.getStockByProductNumber(productNumber);

        StockResponseDto response =
                new StockResponseDto(productNumber, stock);

        return ResponseEntity.ok(response);
    }
}
