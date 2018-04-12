package com.dataart.dshmain.boottest1.service;

import com.dataart.dshmain.boottest1.dto.ProductDto;
import com.dataart.dshmain.boottest1.service.impl.ProductServiceClientFallback;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="product-service", fallback=ProductServiceClientFallback.class)
@Qualifier("productClient")
public interface ProductServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<ProductDto> getProducts();

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    ResponseEntity createProduct(ProductDto product);

}
