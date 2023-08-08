package com.example.furrl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @Column
    private List<CampaignDiscount> campaignDiscounts = new ArrayList<>();
}
