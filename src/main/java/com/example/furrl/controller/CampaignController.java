package com.example.furrl.controller;


import com.example.furrl.model.Campaign;
import com.example.furrl.service.CampaignService;
import com.example.furrl.dto.CreateCampaignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns()
    {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody CreateCampaignRequest campaignRequest) {
        Campaign campaign = campaignService.createCampaign(campaignRequest.getStartDate(), campaignRequest.getEndDate(), campaignRequest.getTitle(), campaignRequest.getCampaignDiscounts());
        return new ResponseEntity<>(campaign, HttpStatus.CREATED);
    }

}

