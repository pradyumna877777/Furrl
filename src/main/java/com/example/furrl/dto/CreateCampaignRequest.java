package com.example.furrl.dto;

import com.example.furrl.model.CampaignDiscount;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateCampaignRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private List<CampaignDiscount> campaignDiscounts;
}
