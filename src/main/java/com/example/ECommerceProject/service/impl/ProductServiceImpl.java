package com.example.ECommerceProject.service.impl;

import com.example.ECommerceProject.model.Product;
import com.example.ECommerceProject.repository.ProductRepository;
import com.example.ECommerceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
