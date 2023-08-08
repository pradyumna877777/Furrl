package com.example.furrl.service;


import com.example.furrl.model.PricingHistory;
import com.example.furrl.model.Product;
import com.example.furrl.repository.PricingHistoryRepository;
import com.example.furrl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PricingHistoryRepository pricingHistoryRepository;

    public List<Product> getAllProducts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.getContent();
    }

}


