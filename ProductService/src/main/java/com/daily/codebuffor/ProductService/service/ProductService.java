package com.daily.codebuffor.ProductService.service;

import com.daily.codebuffor.ProductService.model.ProductRequest;
import com.daily.codebuffor.ProductService.model.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
