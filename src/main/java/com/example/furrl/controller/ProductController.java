package com.example.furrl.controller;


import com.example.furrl.dto.ProductPageResponse;
import com.example.furrl.model.PricingHistory;
import com.example.furrl.model.Product;
import com.example.furrl.service.PricingHistoryService;
import com.example.furrl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<ProductPageResponse> getAllProducts(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> productPage = productService.getAllProducts(page, pageSize);
        ProductPageResponse response = new ProductPageResponse();
        response.setProductData(productPage.getContent());
        response.setPage(page);
        response.setPageSize(pageSize);
        response.setTotalPages(productPage.getTotalPages());

        return ResponseEntity.ok(response);
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

