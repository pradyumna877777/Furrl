package com.example.furrl.controller;


import com.example.furrl.model.PricingHistory;
import com.example.furrl.model.Product;
import com.example.furrl.service.PricingHistoryService;
import com.example.furrl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PricingHistoryService pricingHistoryService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<Product> products = productService.getAllProducts(page, pageSize);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}/price-history")
    public ResponseEntity<List<PricingHistory>> getProductPricingHistory(
            @PathVariable("productId") Long id
    )
    {
        List<PricingHistory> history = pricingHistoryService.getPricingHistory(id);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}

