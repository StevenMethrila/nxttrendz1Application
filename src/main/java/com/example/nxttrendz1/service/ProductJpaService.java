package com.example.nxttrendz1.service;

import com.example.nxttrendz1.service.ProductJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.nxttrendz1.repository.ProductRepository;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.model.Product;

import java.util.*;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    ProductJpaRepository PJR;

    @Override
    public ArrayList<Product> getAllProduct() {
        List<Product> l = PJR.findAll();
        ArrayList<Product> arr = new ArrayList<>(l);
        return arr;
    }

    @Override
    public Product getAllProductById(int productId) {
        try {
            Product p = PJR.findById(productId).get();
            return p;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product createProduct(Product product) {
        PJR.save(product);
        return product;
    }

    @Override
    public Product UpdateProduct(int productId, Product product) {
        try {
            Product r = PJR.findById(productId).get();
            if (product.getProductName() != null) {
                r.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0) {
                r.setPrice(product.getPrice());
            }
            return PJR.save(r);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void DeleteProduct(int productId) {
        try {
            PJR.deleteById(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}