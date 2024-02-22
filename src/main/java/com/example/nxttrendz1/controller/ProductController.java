package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.controller.ProductController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.service.ProductJpaService;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    ProductJpaService PJS;

    @GetMapping("/products")
    public ArrayList<Product> getMethod() {
        return PJS.getAllProduct();
    }

    @GetMapping("/products/{productId}")
    public Product getMethodById(@PathVariable("productId") int productId) {
        return PJS.getAllProductById(productId);
    }

    @PostMapping("/products")
    public Product PostMethod(@RequestBody Product product) {
        return PJS.createProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product putMethod(@PathVariable("productId") int productId, @RequestBody Product product) {
        return PJS.UpdateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void DeleteMethod(@PathVariable("productId") int productId) {
        PJS.DeleteProduct(productId);
    }
}