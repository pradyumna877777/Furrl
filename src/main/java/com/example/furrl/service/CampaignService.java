package com.example.furrl.service;


import com.example.furrl.model.Campaign;
import com.example.furrl.model.CampaignDiscount;
import com.example.furrl.model.Product;
import com.example.furrl.repository.CampaignRepository;
import com.example.furrl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    public Campaign createCampaign(LocalDate startDate, LocalDate endDate, String title, List<CampaignDiscount> campaignDiscounts) {
        Campaign campaign = new Campaign();
        campaign.setStartDate(startDate);
        campaign.setEndDate(endDate);
        campaign.setTitle(title);
        campaign.setCampaignDiscounts(campaignDiscounts);
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getAllCampaigns()
    {
        return campaignRepository.findAll();
    }

}


