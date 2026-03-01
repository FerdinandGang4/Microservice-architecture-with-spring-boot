package com.example.ProductServicev1.Client;

import com.example.StockServicev1.Dto.StockResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "${stock.service.url}")
public interface StockClient {
    @GetMapping("/api/stocks/{productNumber}")
    StockResponseDto getStock(@PathVariable String productNumber);
}
