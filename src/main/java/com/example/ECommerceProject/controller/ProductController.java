package com.example.ECommerceProject.controller;

import com.example.ECommerceProject.model.Product;
import com.example.ECommerceProject.repository.ProductRepository;
import com.example.ECommerceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
      Product savedProduct = productService.createProduct(product);
      return savedProduct;
    }

}
