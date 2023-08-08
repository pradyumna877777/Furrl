package com.example.furrl.ScheduledTasks;


import com.example.furrl.model.Product;
import com.example.furrl.repository.ProductRepository;
import com.example.furrl.service.PricingHistoryService;
import com.example.furrl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PricingUpdateTask {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PricingHistoryService pricingHistoryService;

    @Scheduled(cron = "0 0 0 * * *") // Run daily at midnight
    public void updatePricesAndCreateHistory() {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {

            // check if the promotion is ended
            // create entry with new promotion details if there is new promotion starting immediate next day
            // create entry with initial details if there is no promotion immediate next day

            double oldPrice = product.getCurrentPrice();
            double currentPrice = 500;


            // Update the current price of the product
            product.setCurrentPrice(currentPrice);
            productRepository.save(product);

            // Create pricing history entry
            pricingHistoryService.createPriceHistoryEntry(product, oldPrice, currentPrice);
        }
    }
}

