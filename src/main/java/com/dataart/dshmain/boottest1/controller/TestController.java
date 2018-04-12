package com.dataart.dshmain.boottest1.controller;

import com.dataart.dshmain.boottest1.dto.ProductDto;
import com.dataart.dshmain.boottest1.service.ProductServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Slf4j
@RequestMapping(path = "/test")
public class TestController {

    private ProductServiceClient productServiceClient;

    public TestController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public ResponseEntity getProductsFromProductServiceThroughFeign() {
        log.info("Product list endpoint called");
        return ResponseEntity.ok().body(productServiceClient.getProducts());
    }

    @RequestMapping(path = "/products", method= RequestMethod.POST)
    public ResponseEntity create(@RequestBody ProductDto product) {
        log.info("Product creation endpoint called");
        return productServiceClient.createProduct(product);
    }

}
