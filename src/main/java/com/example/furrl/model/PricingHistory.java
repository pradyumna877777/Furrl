package com.example.furrl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class PricingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Product product;

    @Column(nullable = false)
    private LocalDate changeDate;
    @Column(nullable = false)
    private double oldPrice;
    @Column(nullable = false)
    private double newPrice;
}