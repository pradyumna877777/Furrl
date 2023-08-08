package com.example.furrl.dto;

import com.example.furrl.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductPageResponse {
    private List<Product> productData;
    private int page;
    private int pageSize;
    private int totalPages;

}

