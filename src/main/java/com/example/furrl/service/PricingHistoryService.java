package com.example.furrl.service;

import com.example.furrl.model.PricingHistory;
import com.example.furrl.model.Product;
import com.example.furrl.repository.PricingHistoryRepository;
import com.example.furrl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PricingHistoryService {

    @Autowired
    private PricingHistoryRepository pricingHistoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void createPriceHistoryEntry(Product product, double oldPrice, double newPrice) {
        PricingHistory priceHistory = new PricingHistory();
        priceHistory.setProduct(product);
        priceHistory.setOldPrice(oldPrice);
        priceHistory.setNewPrice(newPrice);
        priceHistory.setChangeDate(LocalDate.now());
        pricingHistoryRepository.save(priceHistory);
    }

    public List<PricingHistory> getPricingHistory(Long id)
    {
        return pricingHistoryRepository.findByProduct_IdOrderByChangeDateDesc(id);
    }
}
