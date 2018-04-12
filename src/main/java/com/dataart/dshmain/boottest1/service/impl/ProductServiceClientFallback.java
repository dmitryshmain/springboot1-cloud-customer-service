package com.dataart.dshmain.boottest1.service.impl;

import com.dataart.dshmain.boottest1.dto.ProductDto;
import com.dataart.dshmain.boottest1.service.ProductServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductServiceClientFallback implements ProductServiceClient {
    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new LinkedList<>();
        return products;
    }

    @Override
    public ResponseEntity createProduct(ProductDto product) {
        return ResponseEntity.ok("Product service is temporarly unavailable");
    }
}
