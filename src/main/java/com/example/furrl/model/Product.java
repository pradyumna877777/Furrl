package com.example.furrl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @JsonIgnore
    private String title;

    @Column
    @JsonIgnore
    private String description;

    @Column(nullable = false)
    private Double mrp;

    @Column
    private Double discount = 0.0;

    @Column(nullable = false)
    private Double currentPrice;

    @Column
    private int inventory = 0;

}
