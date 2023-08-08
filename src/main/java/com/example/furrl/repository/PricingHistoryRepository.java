package com.example.furrl.repository;

import com.example.furrl.model.PricingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingHistoryRepository extends JpaRepository<PricingHistory, Long> {
    List<PricingHistory> findByProduct_IdOrderByChangeDateDesc(Long productId);
}
