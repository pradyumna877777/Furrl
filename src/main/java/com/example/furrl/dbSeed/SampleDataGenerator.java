package com.example.furrl.dbSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.furrl.model.*;
import com.example.furrl.repository.*;

import java.time.LocalDate;

@Component
public class SampleDataGenerator implements CommandLineRunner {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired PricingHistoryRepository pricingHistoryRepository;

    @Override
    public void run(String... args) throws Exception {

        pricingHistoryRepository.deleteAll();
        campaignRepository.deleteAll();
        productRepository.deleteAll();


        // Create sample products
        Product product1 = new Product();
        product1.setTitle("Product 1");
        product1.setDescription("Description for Product 1");
        product1.setMrp(100.0);
        product1.setCurrentPrice(90.0);
        product1.setDiscount(10.0);
        product1.setInventory(10);


        // Save products to the database
        productRepository.save(product1);

        // Create sample campaign
        Campaign campaign = new Campaign();
        campaign.setStartDate(LocalDate.of(2023, 8, 9));
        campaign.setEndDate(LocalDate.of(2023, 8, 15));
        campaign.setTitle("Summer Sale");

        // Create sample campaign discount
        CampaignDiscount campaignDiscount = new CampaignDiscount();
        campaignDiscount.setProductId(product1.getId());
        campaignDiscount.setDiscount(10.0);

        campaign.getCampaignDiscounts().add(campaignDiscount);

        // Save campaign to the database
        campaignRepository.save(campaign);

        // Create price history entry
        PricingHistory pricingHistory1 = new PricingHistory();
        pricingHistory1.setProduct(product1);
        pricingHistory1.setChangeDate(LocalDate.of(2023, 8, 1));
        pricingHistory1.setOldPrice(90.0);
        pricingHistory1.setNewPrice(81.0);

        pricingHistoryRepository.save(pricingHistory1);

        product1.setCurrentPrice(81.0);
        productRepository.save(product1);

    }
}
